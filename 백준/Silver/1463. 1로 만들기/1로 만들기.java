import java.util.Scanner;

public class Main {
  /*
  3으로 나누기 Or 2로 나누기 or 1을 빼기
   */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] dp = new int[n + 1];
    for (int i = 2; i <= n; i++) {
      int first = dp[i - 1] + 1;
      int second = i % 2 == 0 ? dp[i / 2] + 1 : Integer.MAX_VALUE;
      int third = i % 3 == 0 ? dp[i / 3] + 1 : Integer.MAX_VALUE;

      dp[i] = Math.min(first, Math.min(second, third));
    }

    System.out.println(dp[n]);
  }
}
