import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  static ArrayList<Node>[] graph;
  static boolean[] visited;
  static int[] distance;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    graph = new ArrayList[N + 1];

    for (int i = 0; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    // 노드 정보 저장
    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int dis = Integer.parseInt(st.nextToken());
      graph[start].add(new Node(end, dis));
      graph[end].add(new Node(start, dis));
    }

    // 거리 찾기
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      visited = new boolean[N + 1];
      distance = new int[N + 1];

      visited[start] = true;
      dfs(start, end);

      System.out.println(distance[end]);
    }
  }

  static void dfs(int si, int ei) {
    if (si == ei) {
      return;
    }

    for (Node node : graph[si]) {
      int nextNode = node.endNode;

      if (!visited[nextNode]) {
        visited[nextNode] = true;
        distance[nextNode] = distance[si] + node.distance;
        dfs(nextNode, ei);
      }
    }
  }

  static class Node {
    int endNode;
    int distance;

    Node(int endNode, int distance) {
      this.endNode = endNode;
      this.distance = distance;
    }
  }
}
