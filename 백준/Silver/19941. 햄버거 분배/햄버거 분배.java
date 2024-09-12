import java.util.*;
import java.io.*;

public class Main {

  static char[] table;
  static int N, K;
  static int count = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    table = br.readLine().toCharArray();

    for (int i = 0; i < N; i++) {

      int startIndex = i - K < 0 ? 0 : i - K;
      int endIndex = i + K > N - 1 ? N - 1 : i + K;

      if (table[i] == 'P') {
        for (int j = startIndex; j <=  endIndex; j++) {
          if (check(j)) {
            break;
          }
        }
      }
    }

    System.out.println(count);

  }
  
  static boolean check(int index) {
    if (table[index] == 'H') {
      count++;
      table[index] = 'X';
      return true;
    }
    return false;
  }
}
