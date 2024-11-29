import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  /*
  포도주를 최대로 마셔야 하기 때문에,
  연속으로 3잔을 마시지 않기 위해 건너뛰더라도 한 칸을 건너뛴다.
  -> 이동 경우의 수(2가지): 바로 다음 칸으로, 1칸 건너뛰고
   */

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] wines = new int[N];
    int[] dp = new int[N];

    for (int i = 0; i < N; i++) {
      wines[i] = Integer.parseInt(br.readLine());
    }

    if (N == 1) {
      System.out.println(wines[0]);
      return;
    }

    dp[0] = wines[0];
    dp[1] = wines[0] + wines[1];

    if (N > 2) {
      dp[2] = Math.max(Math.max(dp[0], wines[1]) + wines[2], dp[1]);

      for (int i = 3; i < N; i++) {
        dp[i] = Math.max(Math.max(dp[i - 2], dp[i - 3] + wines[i - 1]) + wines[i], dp[i-1]);
        // 2번째 전 dp + 현재 wine vs. 3번째 전 dp + 1번째 전 wine + 현재 wine
      }
    }

    System.out.println(dp[N - 1]);
  }
}
