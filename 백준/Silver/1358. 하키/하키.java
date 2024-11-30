import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int W = Integer.parseInt(st.nextToken());
    int H = Integer.parseInt(st.nextToken());
    int X = Integer.parseInt(st.nextToken());
    int Y = Integer.parseInt(st.nextToken());
    int r = H / 2;
    int P = Integer.parseInt(st.nextToken());

    int count = 0;
    for (int i = 0; i < P; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      if (x >= X && x <= X + W && y >= Y && y <= Y + H) {
        count++;
      } else if (Math.sqrt(Math.pow(x - X, 2) + Math.pow(y - (Y + r), 2)) <= r
          || Math.sqrt(Math.pow(x - (X + W), 2) + Math.pow(y - (Y + r), 2)) <= r) {
        count++;
      }
    }

    System.out.println(count);
  }
}
