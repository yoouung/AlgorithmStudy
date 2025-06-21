import java.util.*;
import java.io.*;

public class Main {
  /*
  1. 약수의 개수에 제한이 없다.
  2. 약수로 음수도 가능하다. (양수라는 제한이 없음)
  -> -1, 1, A로 그 어느 숫자도 구현 가능하다.
  => 어떤 값이 들어오든 무조건 yes를 출력하면 된다.

  ex1) 6, 1
    6 = -1 * -1 * -1 * -1 * -1 * -1 * 1 * 6
    1 = -1 + -1 + -1 + -1 + -1 + -1 + 6 + 1
  ex2) 6, 2
    6 = -1 * -1 * -1 * -1 * -1 * -1 * 1 * 1 * 6
    1 = -1 + -1 + -1 + -1 + -1 + -1 + 6 + 1 + 1
  */

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      sb.append("yes").append("\n");
    }
    System.out.println(sb);
  }
}
