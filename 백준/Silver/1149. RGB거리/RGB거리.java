import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int[][] costs;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    costs = new int[N][3];
    dp = new int[N][3];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      costs[i][0] = Integer.parseInt(st.nextToken());
      costs[i][1] = Integer.parseInt(st.nextToken());
      costs[i][2] = Integer.parseInt(st.nextToken());
    }

    dp[0][0] = costs[0][0];
    dp[0][1] = costs[0][1];
    dp[0][2] = costs[0][2];

    for (int i = 1; i < N; i++) {
      dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
      dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
      dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
    }

    System.out.println(Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2])));
    ;
  }
}
