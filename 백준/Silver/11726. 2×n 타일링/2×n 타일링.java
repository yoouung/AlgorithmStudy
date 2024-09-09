import java.io.*;

public class Main {

  /*
   * dp[n] = dp[n-1] + dp[n-2]
   */


  static int[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    dp = new int[N + 1];

    dp[0] = 0;
    dp[1] = 1;
      
    if (N > 1) {
      dp[2] = 2;
    }
    
    if (N == 1 || N == 2) {
      System.out.println(dp[N]);
      System.exit(0);
    }

    for (int i = 3; i < N + 1; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
    }
    System.out.println(dp[N]);
  }
}

