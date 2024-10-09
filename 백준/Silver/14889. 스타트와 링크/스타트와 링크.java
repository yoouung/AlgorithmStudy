import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int[][] scores;
  static boolean[] visited;
  static int min = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    scores = new int[N][N];
    visited = new boolean[N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        scores[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    backtracking(0, 0);
    System.out.println(min);
  }

  static void backtracking(int index, int depth) { // depth는 스타트팀에 몇명 넣었는지
    if (depth == N / 2) {
      min = Math.min(min, calculateDiff());

      if (min == 0) { // 더이상 작아질 수 없을 떄 early return 해주기 -> 시간복잡도 해결
        System.out.println(min);
        System.exit(0);
        return;
      }
    }

    for (int i = index; i < N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        backtracking(i + 1, depth + 1);
        visited[i] = false;
      }
    }
  }

  static int calculateDiff() {
    int start = 0;
    int link = 0;

    for (int i = 0; i < N - 1; i++) {
      for (int j = i + 1; j < N; j++) {
        if (visited[i] && visited[j]) {
          start += scores[i][j] + scores[j][i];
        } else if (!visited[i] && !visited[j]) {
          link += scores[i][j] + scores[j][i];
        }
      }
    }

    return Math.abs(start - link);
  }
}
