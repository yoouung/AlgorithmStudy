import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    /*
    dp[i][h]: 첫 i명까지 고려했을 때, 체력이 h일 때 얻을 수 있는 최대 기쁨.
    i는 사람의 번호, h는 체력(0~100).

    => i번 사람에게 인사하지 않은 경우, 이전 상태를 그대로 가져옴.
       i번 사람에게 인사한 경우 체력 감소, 기쁨 증가
     */

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] energy = new int[N + 1];
    int[] happy = new int[N + 1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      energy[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      happy[i] += Integer.parseInt(st.nextToken());
    }

    int[][] dp = new int[N + 1][101]; // 0이 되면 죽는다. 99까지만 가능
    for (int i = 1; i <= N; i++) {
      for (int e = 100; e > 0; e--) {
        dp[i][e] = dp[i - 1][e]; // i번 사람에게 인사하지 않는 경우
        if (e > energy[i]) {
          dp[i][e] = Math.max(dp[i][e], dp[i - 1][e - energy[i]] + happy[i]);
        }
      }
    }

    System.out.println(dp[N][100]);
  }
}
