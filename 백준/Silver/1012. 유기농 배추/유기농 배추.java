import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, 1, -1};
  static int N, M, K;
  static int[][] graph;
  static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int i=0; i<T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());
      graph = new int[N][M];
      visited = new boolean[N][M];
      int count = 0;

      for (int j=0; j<K; j++) {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph[n][m] = 1;
      }

      for (int j=0; j<N; j++) {
        for (int k=0; k<M; k++) {
          if (!visited[j][k] && graph[j][k] == 1) {
            dfs(j, k);
            count++;
          }
        }
      }

      System.out.println(count);
    }
  }

  static void dfs(int x, int y) {
    visited[x][y] = true;

    for (int i=0; i<4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
        if (!visited[nx][ny] && graph[nx][ny] == 1) {
          dfs(nx, ny);
        }
      }
    }
  }
}

