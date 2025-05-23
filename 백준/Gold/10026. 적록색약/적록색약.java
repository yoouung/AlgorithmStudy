import java.util.*;
import java.io.*;

public class Main {
  /*
   */

  static int N, realCount, changedCount;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
  static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    char[][] realGraph = new char[N][N];
    char[][] changedGraph = new char[N][N];

    for (int i = 0; i < N; i++) {
      String st = br.readLine();
      for (int j = 0; j < N; j++) {
        realGraph[i][j] = st.charAt(j);
        changedGraph[i][j] = st.charAt(j) == 'G' ? 'R' : st.charAt(j);
      }
    }

    visited = new boolean[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visited[i][j]) {
          realCount++;
          dfs(realGraph, i, j);
        }
      }
    }

    visited = new boolean[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visited[i][j]) {
          changedCount++;
          dfs(changedGraph, i, j);
        }
      }
    }

    System.out.println(realCount + " " + changedCount);
  }

  static void dfs(char[][] graph, int cx, int cy) {
    visited[cx][cy] = true;

    for (int i = 0; i < 4; i++) {
      int nx = cx + dx[i];
      int ny = cy + dy[i];
      if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
        if (!visited[nx][ny] && graph[cx][cy] == graph[nx][ny]) {
          dfs(graph, nx, ny);
        }
      }
    }
  }
}
