import java.util.*;
import java.io.*;

public class Main {
  /*
  Graph
  */

  static int n, m;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
  static int[][] graph;
  static boolean[][] visited;
  static int count = 0, maxSize = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    graph = new int[n][m];
    visited = new boolean[n][m];

    for (int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j=0; j<m; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i=0; i<n; i++) {
      for (int j=0; j<m; j++) {
        if (!visited[i][j] && graph[i][j] == 1) {
          count++;
          visited[i][j] = true;
          int size = dfs(i, j);
          maxSize = Math.max(size, maxSize);
        }
      }
    }

    System.out.println(count);
    System.out.println(maxSize);
  }

  static int dfs(int cx, int cy) {
    int size = 1;
    for (int i=0; i<4; i++) {
      int nx = cx + dx[i];
      int ny = cy + dy[i];
      if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && graph[nx][ny] == 1) {
        visited[nx][ny] = true;
        size += dfs(nx, ny);
      }
    }
    return size;
  }
}
