import java.util.*;
import java.io.*;

public class Main {
  /*
  대각선 왼쪽 계산하기 쉽게 N+1 크기로 배열 선언
  */

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] graph = new int[N+1][N+1];

    int l = 1;
    for (int i=1; i<=N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j=1; j<=l; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
      l++;
    }

    int[][] dp = new int[N+1][N+1];
    for (int i=1; i<=N; i++) {
      for (int j=1; j<=N; j++) {
        dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + graph[i][j];
      }
    }

    int result = 0;
    for (int i=1; i<=N; i++) {
      result = Math.max(result, dp[N][i]);
    }
    System.out.println(result);
  }
}
