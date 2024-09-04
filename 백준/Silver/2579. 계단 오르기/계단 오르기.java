import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  static int[] dp;
  static int[] arr;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    dp = new int[N + 1];
    arr = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    Arrays.fill(dp, -1);
    dp[0] = 0;
    dp[1] = arr[1];

    if (N >= 2) {
      dp[2] = arr[1] + arr[2];
    }

    System.out.println(findMax(N));
  }
  
  static int findMax(int index) {
    if (dp[index] == -1) {
      dp[index] = Math.max(findMax(index - 2), findMax(index - 3) + arr[index - 1]) + arr[index];
    }

    return dp[index];
  }
}
