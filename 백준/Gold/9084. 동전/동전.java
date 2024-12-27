import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < T; i++) {
      int N = Integer.parseInt(br.readLine());
      int[] coins = new int[N];

      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        coins[j] = Integer.parseInt(st.nextToken());
      }
      int M = Integer.parseInt(br.readLine());
      int[] dp = new int[M + 1];

      dp[0] = 1;
      for (int c = 0; c < N; c++) {
        for (int j = 1; j <= M; j++) {
          if (j >= coins[c]) {
            dp[j] = dp[j] + dp[j - coins[c]];
          }

        }
      }
      sb.append(dp[M]).append('\n');
    }
    System.out.println(sb.toString());
  }
}
