import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  /*
  1. 모든 행을 돌며 각 행에 포함된 0의 개수를 센다.
  2. k가 짝수라면 0의 개수도 짝수, k가 홀수라면 0의 개수도 홀수여야 한다.
   */

  static int N, M;
  static int[][] lamps;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    lamps = new int[N][M];

    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      for (int j = 0; j < M; j++) {
        lamps[i][j] = s.charAt(j) - '0';
      }
    }

    int K = Integer.parseInt(br.readLine());
    int max = getMax(K);

    System.out.println(max);
  }

  private static int getMax(int K) {
    int max = 0;

    for (int i = 0; i < N; i++) {
      int countZero = 0;
      int samePattern = 0;

      for (int j = 0; j < M; j++) {
        if (lamps[i][j] == 0) {
          countZero++;
        }
      }

      if (countZero <= K && countZero % 2 == K % 2) {
        // 0의 개수가 k보다 작거나 같고, 둘 다 짝수이거나 둘 다 홀수인 경우

        for (int j = 0; j < N; j++) {
          // 현재 행과 같은 패턴인 행 찾기
          if (isEqual(i, j)) { // i == j인 경우도 포함하는 이유: 0이 기본값이므로 1을 따로 더해주기 위해
            samePattern++;
          }
          max = Math.max(samePattern, max);
        }
      }
    }
    return max;
  }

  static boolean isEqual(int i, int j) {
    for (int k = 0; k < M; k++) {
      if (lamps[i][k] != lamps[j][k]) return false;
    }
    return true;
  }
}
