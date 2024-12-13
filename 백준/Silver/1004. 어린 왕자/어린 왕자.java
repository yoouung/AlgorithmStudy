import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  /*
  둘 다 원 안에, 원 밖에 -> x
  둘 중 하나만 원 안에 -> +1
   */

  static int x1, y1, x2, y2;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      x1 = Integer.parseInt(st.nextToken());
      y1 = Integer.parseInt(st.nextToken());
      x2 = Integer.parseInt(st.nextToken());
      y2 = Integer.parseInt(st.nextToken());

      int n = Integer.parseInt(br.readLine());
      int count = 0;
      for (int j = 0; j < n; j++) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        if (!isAllInOrOut(x, y, r)) {
          count++;
        }
      }

      System.out.println(count);
    }
  }

  static boolean isAllInOrOut(int x, int y, int r) {
    boolean result = false;

    if (Math.pow((x1 - x), 2) + Math.pow((y1 - y), 2) < Math.pow(r, 2)
        && Math.pow((x2 - x), 2) + Math.pow((y2 - y), 2) < Math.pow(r, 2)) {
      result = true;
    } else if (Math.pow((x1 - x), 2) + Math.pow((y1 - y), 2) > Math.pow(r, 2)
        && Math.pow((x2 - x), 2) + Math.pow((y2 - y), 2) > Math.pow(r, 2)) {
      result = true;
    }

    return result;
  }
}
