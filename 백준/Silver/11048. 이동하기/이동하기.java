import java.util.*;
import java.io.*;

public class Main {
  /*
  처음 생각: 백트레킹: 재귀함수 전후로 visited 조정 -> 시간초과
  DP
   */

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[][] candy = new int[N][M];
    int[][] dp = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        candy[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dp[0][0] = candy[0][0];
    // 테두리 영역은 미리 계산
    for (int i=1; i<N; i++) {
      dp[i][0] = dp[i-1][0] + candy[i][0];
    }
    for (int i=1; i<M; i++) {
      dp[0][i] = dp[0][i-1] + candy[0][i];
    }

    for (int i = 1; i < N; i++) {
      for (int j = 1; j < M; j++) {
        dp[i][j] = Math.max(dp[i][j - 1], Math.max(dp[i - 1][j], dp[i - 1][j - 1])) + candy[i][j];
      }
    }

    System.out.println(dp[N - 1][M - 1]);
  }
}
