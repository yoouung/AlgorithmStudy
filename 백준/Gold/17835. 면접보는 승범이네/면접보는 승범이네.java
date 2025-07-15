import java.util.*;
import java.io.*;

public class Main {
  /*
  다익스트라 알고리즘
  === 내가 생각했던 부분 (시간 초과, 틀렸음)
  1. 도시->면접장까지의 거리 말고 면접장->각 도시까지의 거리를 구하기 (reverse) => 시작노드가 명확함
  === 내가 생각하지 못했던 부분
  2. 최악의 경우 int 범위를 벗어날 수 있음: 최대 거리 = (N-1) * C = 9,999,900,000 (약 100억), int 최댓값: 약 21억
  3. 방문한 노드 기록 visited: 우선순위 큐에서 꺼낸 노드는 이미 최단거리가 확정된 노드이다. 현재 가장 거리가 짧은 노드를 꺼내기 때문
    - 자세한 증명은 아래에
   */

  static class Node implements Comparable<Node> {
    int endNode;
    long dist;

    Node(int endNode, long dist) {
      this.endNode = endNode;
      this.dist = dist;
    }

    public int compareTo(Node o) { // 반환값은 -1, 0, 1 중 하나이므로 int
      return Long.compare(this.dist, o.dist);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    ArrayList<Node>[] graph = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      graph[e].add(new Node(s, d)); // reversed
    }

    List<Integer> interviewRooms = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < K; i++) {
      interviewRooms.add(Integer.parseInt(st.nextToken()));
    }

    long[] dist = dijkstra(graph, N, interviewRooms);

    long maxDist = 0;
    int maxIdx = 0;
    for (int i = 1; i <= N; i++) {
      if (maxDist < dist[i]) {
        maxDist = dist[i];
        maxIdx = i;
      }
    }
    System.out.println(maxIdx);
    System.out.println(maxDist);
  }

  static long[] dijkstra(ArrayList<Node>[] graph, int N, List<Integer> startNodes) {
    long[] dist = new long[N+1];
    boolean[] visited = new boolean[N+1];
    Arrays.fill(dist, Long.MAX_VALUE);

    PriorityQueue<Node> pq = new PriorityQueue<>();
    for (int startNode: startNodes) {
      dist[startNode] = 0;
      pq.offer(new Node(startNode, 0));
    }

    while (!pq.isEmpty()) {
      Node prevNode = pq.poll();
      int currentIdx = prevNode.endNode;
      if (visited[currentIdx]) continue;
      visited[currentIdx] = true;

      for (Node nextNode : graph[currentIdx]) {
        int nextIdx = nextNode.endNode;
        long nextDist = nextNode.dist;
        if (dist[currentIdx] + nextDist < dist[nextIdx] && !visited[nextIdx]) {
          dist[nextIdx] = dist[currentIdx] + nextDist;
          pq.offer(new Node(nextIdx, dist[nextIdx]));
        }
      }
    }
    return dist;
  }
}