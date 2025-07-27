import java.util.*;
import java.io.*;

public class Main {
  /*
  시간 1초 제한인데 N 범위, a 값들의 범위 너무 크다
  Map: { 3: [0], 2: [1], 5: [2, 3] ..}
  투포인터: left=0, right=0부터 시작, 조건 만족 시: right 확장 / 조건 위반 시: left 이동하여 조건 복구
   */

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int[] list = new int[N];

    HashMap<Integer, Integer> count = new HashMap<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      list[i] = Integer.parseInt(st.nextToken());
    }

    int left = 0;
    int maxLen = 0;

    for (int right = 0; right < N; right++) {
      int r = list[right];
      count.put(r, count.getOrDefault(r, 0) + 1);

      while (count.get(r) > K) {
        int l = list[left];
        count.put(l, count.get(l) - 1);
        if (count.get(l) == 0) {
          count.remove(l);
        }
        left++;
      }

      maxLen = Math.max(maxLen, right - left + 1);
    }

    System.out.println(maxLen);
  }
}