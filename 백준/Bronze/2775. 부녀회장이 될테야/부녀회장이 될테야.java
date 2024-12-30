import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    int[][] dp = new int[15][15];
    for (int i = 0; i <= 14; i++) {
      dp[0][i] = i;
    }
    for (int i = 1; i <= 14; i++) { // 층
      for (int j = 1; j <= 14; j++) { // 호
        int count = 0;
        for (int k = 1; k <= j; k++) {
          count += dp[i - 1][k];
        }
        dp[i][j] = count;
      }
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      int k = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      System.out.println(dp[k][n]);
    }
  }
}
