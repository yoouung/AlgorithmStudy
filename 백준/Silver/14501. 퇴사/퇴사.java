import java.util.*;
import java.io.*;

public class Main {
  /*
  dp....?
  이전 상담 다 돌아보면서 현재 날짜까지 가능한 상담비 계산

  시간복잡도 줄이기:
  - 거꾸로 DP (i + time[i]가 N+1 이하여야 한다. 즉, 뒤에서부터 보면 앞으로 갈 수 있는 경우가 명확해짐)
  */

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] time = new int[N + 1];
    int[] pay = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      time[i] = Integer.parseInt(st.nextToken());
      pay[i] = Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[N + 2]; // i일부터 시작했을 때의 최대 수익
    for (int i = N; i >= 1; i--) {
      int nextDay = i + time[i];
      if (nextDay <= N + 1) {
        dp[i] = Math.max(pay[i] + dp[nextDay], dp[i + 1]); // 상담 O vs 상담 X
      } else {
        dp[i] = dp[i + 1]; // 상담 불가 → 이전 값 유지
      }
    }

    /* 시간복잠도 O(n^2)
    int[] max = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      max[i] = max[i - 1];
      for (int j = 1; j <= i; j++) {
        if (j + time[j] == i + 1) { // 당일 상담 가능한 경우까지
          max[i] = Math.max(max[j - 1] + pay[j], max[i]);
        }
      }
    }
     */

    System.out.println(dp[1]);
  }
}
