import java.util.*;

class Solution {
    /*
    - 구하는 것: 최단경로로 이동했을때 간선의 개수가 가장 많은 노드의 개수
    - 조건
    1. 2 <= 노드개수 n <= 20,000
    2. 양방향 간선, 가중치 없음, 간선 개수(edge 길이) < 50,000
    3. 
    - 내가 생각한 로직: 각 노드별 최단경로 간선 수 구하고, 최댓값인 노드 개수 계산. 어차피 모든 노드까지의 거리를 구해야 함
    - 알고리즘 후보: bfs
    */
    
    /* distance 배열에 직접 거리 저장하므로 node 필요없음
        class Node {
            int node;
            int distance;

            Node(int node, int distance) {
                this.node = node;
                this.distance = distance;
            }
        }
    */
    
    List<List<Integer>> graph = new ArrayList<>();
    
    public int solution(int n, int[][] edge) {
        for (int i=0; i<n+1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e: edge) {
            int start = e[0];
            int end = e[1];
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        
        int[] distance = bfs(1, n);
        int max = 0;
        
        
        for (int i=2; i<=n; i++) {
            max = Math.max(max, distance[i]);
        }
        
        int answer = 0;
        for (int i=2; i<=n; i++) {
            if (distance[i] == max) {
                answer++;
            }
        }
        
        return answer;
    }
    
    int[] bfs(int start, int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] distance = new int[n+1];
        
        // -1는 아직 방문하지 않았다는 의미 -> visited[] 필요없음
        Arrays.fill(distance, -1);
        
        queue.offer(start);
        distance[start] = 0;
            
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int next: graph.get(current)) {
                if (distance[next] == -1) {
                    distance[next] = distance[current] + 1;
                    queue.offer(next);
                }
            }
        }
        
        return distance;
    }
}