import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int[][] items = new int[N + 1][2];
    int[][] dp = new int[K + 1][N + 1];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      items[i][0] = Integer.parseInt(st.nextToken());
      items[i][1] = Integer.parseInt(st.nextToken());
    }

    for (int k = 1; k <= K; k++) { // 무게
      for (int i = 1; i <= N; i++) { // 물건
        if (items[i][0] > k) {
          dp[k][i] = dp[k][i - 1];
        } else {
          dp[k][i] = Math.max(dp[k][i - 1], items[i][1] + dp[k - items[i][0]][i - 1]);
        }
      }
    }

    System.out.println(dp[K][N]);
  }
}
