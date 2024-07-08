import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    int INF = 5001; // 최댓값
    int[] dp = new int[N + 1];
    Arrays.fill(dp, INF);
    dp[0] = 0;
    
    for (int i = 1; i < N + 1; i++) {
      if (i >= 3) {
        dp[i] = Math.min(dp[i], dp[i - 3] + 1);
      }
      if (i >= 5) {
        dp[i] = Math.min(dp[i], dp[i - 5] + 1);
      }
    }

    if (dp[N] == INF) {
      System.out.println(-1);
    } else {
      System.out.println(dp[N]);
    }
  }
}
