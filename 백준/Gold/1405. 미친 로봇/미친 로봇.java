import java.io.*;
import java.util.*;

public class Main {
  /*
  브루트포스, dfs, 백트레킹
   */
  static int n;
  static double answer;
  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, 1, -1};
  static double[] percents;
  static boolean[][] visited = new boolean[29][29]; // n<14 이므로 최대 크기

  public static void main(String[] args) throws  Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    percents = new double[4];
    for (int i=0; i<4; i++) {
      percents[i] = Integer.parseInt(st.nextToken()) * 0.01;
    }

    visited[14][14] = true;
    dfs(14, 14, 0, 1); // 시작할 때 확률은 1.0
    System.out.println(answer);
  }

  static void dfs(int cx, int cy, int count, double result) {
    if (count == n) {
      answer += result;
      return;
    }

    for (int i=0; i<4; i++) {
      int nx = cx + dx[i];
      int ny = cy + dy[i];
      if (nx >= 0 && nx < 29 && ny >= 0 && ny < 29) {
        if (!visited[nx][ny]) {
          visited[nx][ny] = true;
          dfs(nx, ny, count + 1, result * percents[i]);
          visited[nx][ny] = false;
        }
      }
    }
  }
}
