import java.util.*;
import java.io.*;

public class Main {
  static int N;
  static long[][] dp;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    dp = new long[N+1][10]; // 자릿수별 숫자 개수
    Arrays.fill(dp[1], 1);
    dp[1][0] = 0; // 가장 앞 숫자는 0이 될 수 없음

    for (int i=2; i<=N; i++) {
      for (int j=0; j<10; j++) {
        if (j == 0) {
          dp[i][j] = dp[i-1][1] % 1000000000;
        } else if (j == 9) {
          dp[i][j] = dp[i-1][8] % 1000000000;
        } else {
          dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
        }
      }
    }

    long count = 0;
    for (int i=0; i<10; i++) {
      count += dp[N][i];
    }
    System.out.println(count % 1000000000);
  }
}
