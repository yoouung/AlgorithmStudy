import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    boolean[][] board = new boolean[101][101];
    int count = 0;

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int first = Integer.parseInt(st.nextToken());
      int second = Integer.parseInt(st.nextToken());

      for (int j = first; j < first + 10; j++) {
        for (int k = second; k < second + 10; k++) {
          if (!board[j][k]) {
            board[j][k] = true;
            count++;

          }
        }
      }
    }

    System.out.println(count);
    
  }
}
