import java.util.*;
import java.io.*;

public class Main {
  /*
  다익스트라 알고리즘
  - dist[]: 시작점 K로부터의 i번쨰 노드까지의 거리
   */

  static class Node implements Comparable<Node> {
    int endNode, w;

    Node(int endNode, int w) {
      this.endNode = endNode;
      this.w = w;
    }

    public int compareTo(Node o) {
      // 둘의 차이가 크면 오버플로우 발생할 수 있으므로 -> Integer.compare 사용
      return Integer.compare(this.w, o.w);
    }
  }

  static int[] dist;
  static ArrayList<Node>[] graph;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(br.readLine());

    graph = new ArrayList[V + 1];
    for (int i = 1; i <= V; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      graph[u].add(new Node(v, w));
    }

    StringBuilder sb = new StringBuilder();
    dist = new int[V + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[K] = 0;

    dijkstra(K);
    for (int i = 1; i <= V; i++) {
      if (dist[i] != Integer.MAX_VALUE) {
        sb.append(dist[i]).append("\n");
      } else {
        sb.append("INF\n");
      }
    }

    System.out.println(sb);
  }

  static void dijkstra(int startNode) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(startNode, 0));

    while (!pq.isEmpty()) {
      Node prevNode = pq.poll();
      int currentIdx = prevNode.endNode;

      for (Node nextNode : graph[currentIdx]) {
        int nextIdx = nextNode.endNode;
        int nextWeight = nextNode.w;
        if (dist[currentIdx] + nextWeight < dist[nextIdx]) {
          dist[nextIdx] = dist[currentIdx] + nextWeight;
          pq.offer(new Node(nextIdx, dist[nextIdx]));
        }
      }
    }
  }
}