import java.io.*;
import java.util.*;

public class Main {
  static int N, M;
  static int[] positions;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());
    positions = new int[N + 1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      positions[i] = Integer.parseInt(st.nextToken());
    }

    findHeight();
  }
  
  static void findHeight() {
    int start = 0;
    int end = N;
    int result = 0;

    while (start <= end) {
      int mid = (start + end) / 2;
      
      if (canCover(mid)) {
        result = mid;
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    System.out.println(result);

  }
  
  static boolean canCover(int height) {
    if (positions[0] > height || N - positions[M-1] > height) {
      return false;
    }

    for (int i = 1; i < M; i++) {
      if (positions[i] - positions[i - 1] > 2 * height) {
        return false;
      }
    }
    return true;
  }
}
