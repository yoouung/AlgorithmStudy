import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  /*
  C(n, k) = C(n-1, k-1) + C(n-1,k)
   */
  static int[][] dp = new int[31][31];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    // dp 배열 초기화: nC0 = 1, nCn = 1
    for (int j = 0; j <= 30; j++) {
      dp[j][0] = 1;
      dp[j][j] = 1;
    }

    combination();

    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      
      System.out.println(dp[m][n]);
    }
  }

  static void combination() {

    for (int n = 1; n <= 30; n++) {
      for (int k = 1; k <= n; k++) {
        // k는 n보다 작거나 같다.
        dp[n][k] = dp[n - 1][k - 1] + dp[n - 1][k];
      }
    }
  }
}
