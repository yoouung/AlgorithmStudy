import java.util.*;
import java.io.*;

public class Main {
  /*
  최소 누적합 -> Pn이 작은 순서대로 줄을 서야 한다.
   */

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] p = new int[N];
    int[] sum = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i=0; i<N; i++) {
      p[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(p);

    sum[0] = p[0];
    int total = sum[0];
    for (int i=1; i<N; i++) {
      sum[i] = sum[i-1] + p[i];
      total += sum[i];
    }
    System.out.println(total);
  }
}
