import java.util.*;

public class Main {
  /*
   * dp[i] = dp[i - coin] + dp[i]
   */

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();

    int[] coins = new int[n];
    int[] dp = new int[k + 1];
    dp[0] = 1;

    for (int i = 0; i < n; i++) {
      coins[i] = sc.nextInt();
    }
    Arrays.sort(coins);
    
    for (int i = 0; i < n; i++) {
      for (int j = 1; j < k + 1; j++) {
        if (j >= coins[i]) {
          dp[j] += dp[j - coins[i]];
        }
      }
    }
    
    System.out.println(dp[k]);
  }
}
