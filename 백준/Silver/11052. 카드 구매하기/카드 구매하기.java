import java.util.*;
import java.io.*;

public class Main {
  /*
  처음 생각: 백트레킹- 최대 돈으로 카드 n개 => 시간초과
  ---
  시간복잡도 줄이려면 DP를 사용 (배낭 문제)
  dp[i] = 카드 i장을 구매할 때 지불할 수 있는 최대 금액
   */

  static int N;
  static int[] packs, dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    packs = new int[N + 1];
    dp = new int[N + 1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      packs[i] = Integer.parseInt(st.nextToken());
    }
    dp[1] = packs[1]; // 1은 1개 패키지 사는 방법 뿐

    for (int i = 2; i <= N; i++) {
      for (int j = 1; j <= i; j++) {
        dp[i] = Math.max(dp[i], dp[i - j] + packs[j]);
      }
    }
    System.out.println(dp[N]);
  }
}
