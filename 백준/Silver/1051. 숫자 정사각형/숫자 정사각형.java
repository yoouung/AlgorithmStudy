import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[][] graph;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    graph = new int[N][M];

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < M; j++) {
        graph[i][j] = line.charAt(j) - '0';
      }
    }

    // 브루트포스 알고리즘
    int max = Math.min(N, M);
    for (int size = max; size >= 1; size--) {
      int len = size - 1;

      for (int i = 0; i <= N - size; i++) {
        for (int j = 0; j <= M - size; j++) {
          if (isPossible(len, i, j)) {
            System.out.println(size * size);
            return;
          }
        }
      }
    }
  }

  static boolean isPossible(int len, int i, int j) {
    return graph[i][j] == graph[i + len][j]
        && graph[i][j] == graph[i][j + len]
        && graph[i][j] == graph[i + len][j + len];
  }
}
