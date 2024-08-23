import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[] staffs = new int[N];

    int max = Integer.MIN_VALUE;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      staffs[i] = Integer.parseInt(st.nextToken());
      max = Math.max(max, staffs[i]);
    }

    long start = 1;
    long end = (long) max * M;
    long time = 0;

    while (start <= end) {
      long mid = (start + end) / 2;
      long balloons = 0;

      for (int i = 0; i < N; i++) {
        balloons +=  mid / staffs[i];
      }

      if (balloons >= M) {
        end = mid - 1;
        time = mid;
      } else {
        start = mid + 1;
      }
    }

    System.out.println(time);
  }
}