import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static int[][] brands;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    brands = new int[M][2];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      brands[i][0] = Integer.parseInt(st.nextToken());
      brands[i][1] = Integer.parseInt(st.nextToken());
    }

    System.out.println(calculate(N));
  }

  static int calculate(int n) {
    if (n <= 6) {
      int min = Integer.MAX_VALUE;
      for (int i = 0; i < M; i++) {
        min = Math.min(min, Math.min(brands[i][0], brands[i][1] * n));
      }
      return min;
    }

    int times = N / 6;
    return calculate(6) * times + calculate(N % 6);
  }
}
