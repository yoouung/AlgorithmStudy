import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  /*
  두 원이 서로 밖에 있으며 만나지 않는다: r + r' < d
  외접한다: r + r' = d
  서로 다른 두 점에서 만난다: r - r' < d < r + r'
  내접한다: r - r' = d
  내부에 있으며 만나지 않는다 : r - r' > d
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int i=0; i<T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int r1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      int r2 = Integer.parseInt(st.nextToken());

      double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

      // 두 원이 동일한 경우 (무한대의 교점)
      if (distance == 0 && r1 == r2) {
        System.out.println(-1);
      }
      // 두 원이 외접하거나 내접하는 경우 (한 점에서 만남)
      else if (distance == r1 + r2 || distance == Math.abs(r1 - r2)) {
        System.out.println(1);
      }
      // 두 원이 서로 다른 두 점에서 만나는 경우
      else if (Math.abs(r1 - r2) < distance && distance < r1 + r2) {
        System.out.println(2);
      }
      // 두 원이 만나지 않는 경우
      else {
        System.out.println(0);
      }
    }
  }
}
