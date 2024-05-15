import java.util.*;
import java.io.*;

public class Main {
  /*
   * 최대한 많은 사람이 고양이 2마리를 데리고 있는다.
   * = 무게 합이 k를 넘지 않는 가장 많은 고양이 쌍의 개수를 찾는다.
   * => 가장 큰 무게와 작은 무게의 합
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken()); // # of cat
    int k = Integer.parseInt(st.nextToken()); // max weight

    st = new StringTokenizer(br.readLine());
    int[] weights = new int[n];
    for (int i = 0; i < n; i++) {
      weights[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(weights); // 오름차순 정렬

    int first = 0;
    int second = n - 1;
    int count = 0;

    while (first < second) {
      if (weights[first] + weights[second] <= k) {
        count++;
        first++;
        second--;
      } else {
        second--;
      }
    }

    System.out.println(count);
  }
}
