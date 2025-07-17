import java.util.*;
import java.io.*;

public class Main {
  /*
  다익스트라
  - 출발점 여러개 -> visited
  - 입력값 받을 때 1, -1인 경우를 모두 저장하므로 graph 배열이 필요없다. 저장되지 않은 좌표는 모두 0인 것.
  ====
  다익스트라 알고리즘은 간선의 가중치가 모두 다를 때 사용하는 알고리즘
  이 문제에는 단순 bfs로도 충분히 풀린다.
  - bfs는 거리 순서대로 노드를 탐색하기 때문에 각 노드에 처음 도달하는 순간이 바로 최단거리이다.
  - 그래서 값이 0인 경우에만 이전 값 + 1 해주면 됨
  */

  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
  static int n, m;
  static int[][] graph;
  static Queue<int[]> queue = new LinkedList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    graph = new int[n][m]; // n, m 스위치

    boolean alreadyMature = true;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        int t = Integer.parseInt(st.nextToken());
        graph[i][j] = t;
        if (t == 1) {
          queue.offer(new int[] {i, j});
        } else if (t == 0 && alreadyMature) {
          alreadyMature = false;
        }
      }
    }

    if (alreadyMature) {
      System.out.println(0);
      return;
    }

    bfs();
    int maxDist = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (graph[i][j] == 0) {
          System.out.println(-1);
          return;
        }
        maxDist = Math.max(maxDist, graph[i][j]);
      }
    }
    System.out.println(maxDist -1);
  }

  static void bfs() {
    while (!queue.isEmpty()) {
      int[] currentNode = queue.poll();
      int cx = currentNode[0];
      int cy = currentNode[1];

      for (int i = 0; i < 4; i++) {
        int nx = cx + dx[i];
        int ny = cy + dy[i];
        if (nx >= 0 && nx < n && ny >= 0 && ny < m && graph[nx][ny] == 0) {
          graph[nx][ny] = graph[cx][cy] + 1;
          queue.offer(new int[] {nx, ny});
        }
      }
    }
  }
}