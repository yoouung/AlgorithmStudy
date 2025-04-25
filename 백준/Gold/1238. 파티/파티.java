import java.util.*;
import java.io.*;

public class Main {
  /*
  다익스트라
  - X -> 각 마을로 가는 최단 거리: 다익스트라 그래프 graph
  - 각 마을 -> X로 가는 최단 거리: graph 역방향 그래프 reversedGraph
    : 역방향이 유효한 이유 - 방향 생각하지 말고 거리만 따짐
  -> 왕복 시간 = 두 값을 더한 후 max 계산
   */
  static int N, M, X;

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());
    ArrayList<Node>[] graph = new ArrayList[N+1];
    ArrayList<Node>[] reversedGraph = new ArrayList[N+1];

    for (int i=0; i<=N; i++) {
      graph[i] = new ArrayList<>();
      reversedGraph[i] = new ArrayList<>();
    }

    for (int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int time = Integer.parseInt(st.nextToken());
      graph[from].add(new Node(to, time));
      reversedGraph[to].add(new Node(from, time));
    }

    int[] fromX =  dijkstra(graph, X);
    int[] toX = dijkstra(reversedGraph, X);

    int maxTime = 0;
    for (int i=1; i<=N; i++) {
      maxTime = Math.max(maxTime, fromX[i] + toX[i]);
    }
    System.out.println(maxTime);
  }

  static int[] dijkstra(ArrayList<Node>[] graph, int startNode) {
    int[] time = new int[N+1];
    Arrays.fill(time, Integer.MAX_VALUE);
    time[startNode] = 0;

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(startNode, 0));

    while (!pq.isEmpty()) {
      Node prevNode = pq.poll();
      int currentIdx = prevNode.endNode;

      if (prevNode.time > time[currentIdx]) continue;

      for (Node nextNode: graph[currentIdx]) {
        if (time[nextNode.endNode] > time[currentIdx] + nextNode.time) {
          time[nextNode.endNode] = time[currentIdx] + nextNode.time;
          pq.offer(new Node(nextNode.endNode, time[nextNode.endNode]));
        }
      }
    }

    return time;

  }

  static class Node implements Comparable<Node> {
    int endNode, time;

    Node(int endNode, int time) {
      this.endNode = endNode;
      this.time = time;
    }

    // 우선순위 큐용 -> PrioritQueue<Node>가 시간 오름차순으로 정렬
    public int compareTo(Node o) {
      return this.time - o.time;
    }
  }
}
