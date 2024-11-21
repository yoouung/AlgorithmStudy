import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int R, C, K;
  static char[][] graph;
  static boolean[][] visited;
  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, 1, -1};
  static int count = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    graph = new char[R][C];
    visited = new boolean[R][C];

    for (int i = 0; i < R; i++) {
      String line = br.readLine();
      for (int j = 0; j < C; j++) {
        graph[i][j] = line.charAt(j);
      }
    }

    visited[R - 1][0] = true;
    dfs(1, R - 1, 0);
    System.out.println(count);
  }

  static void dfs(int depth, int x, int y) {
    if (depth > K) {
      return;
    }

    if (x == 0 && y == C - 1) {
      if (depth == K) count++;
      return;
    }

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
        if (!visited[nx][ny] && graph[nx][ny] == '.') {
          visited[nx][ny] = true;
          dfs(depth + 1, nx, ny);
          visited[nx][ny] = false;
        }
      }
    }
  }
}
