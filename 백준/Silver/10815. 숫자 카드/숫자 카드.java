import java.util.*;
import java.io.*;

public class Main {
  /*
  이분탐색
  - 입력값들의 범위가 큼 -> 굉장히 효율적인 알고리즘 필요
  - 타겟 값의 존재 유무만 빠르게 판단하면 됨
  */

  static int[] sang;
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    sang = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i=0; i<N; i++) {
      sang[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(sang);


    StringBuilder sb = new StringBuilder();
    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i=0; i<M; i++) {
      int x = Integer.parseInt(st.nextToken());
      if (check(x)) {
        sb.append('1');
      } else {
        sb.append('0');
      }
      sb.append(" ");
    }
    System.out.println(sb);
  }

  static boolean check(int target) {
    int start = 0;
    int end = N-1;

    while (start <= end) {
      int mid = (start + end) / 2;
      if (sang[mid] < target) {
        start = mid + 1;
      } else if (sang[mid] > target) {
        end = mid - 1;
      } else {
        return true;
      }
    }

    return false;
  }
}