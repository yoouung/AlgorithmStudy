import java.util.*;

class Solution {
    /*
    - 구하는 것: k 안에 배달가능한 마을의 개수
    - 조건
    1. 노드마다 가중치가 다름
    2. 두 마을을 연결하는 도로가 여러개 있을 수 있음
    3. start node는 1번
    */
    
    class Node {
        int destination;
        int time;
        
        Node (int destination, int time) {
            this.destination = destination;
            this.time = time;
        }
    }
    
    List<List<Node>> graph = new ArrayList<>();
    
    public int solution(int N, int[][] road, int K) {
        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge: road) {
            int start = edge[0];
            int end = edge[1];
            int time = edge[2];
            
            graph.get(start).add(new Node(end, time));
            graph.get(end).add(new Node(start, time));
        }
        
        int[] distance = dijkstra(N, K);
        
        int answer = 0;
        for (int i=0; i<=N; i++) {
            if (distance[i] <= K) {
                answer++;
            }
        }
        return answer;
    }
    
    int[] dijkstra(int n, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));
        pq.add(new Node(1, 0));
        
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        
        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int current = currentNode.destination;
            int ctime = currentNode.time;
            
            // 가장 첫 요소의 time이 이미 k 초과라면 더 볼 필요 없음
            if (ctime > k) {
                break;
            }
            
            // 이미 더 빠른 경로를 찾아둔 경우
            if (ctime > distance[current]) {
                continue;
            }
            
            for (Node node: graph.get(current)) {
                int next = node.destination;
                int ntime = node.time;
                int timeSum = ctime + ntime;
                
                if (timeSum <= distance[next]) {
                    distance[next] = timeSum;
                    pq.offer(new Node(next, timeSum));
                }
            }
        }
        
        return distance;
    }
}