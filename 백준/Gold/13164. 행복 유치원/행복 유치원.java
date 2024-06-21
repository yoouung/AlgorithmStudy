import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] heights = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      heights[i] = Integer.parseInt(st.nextToken());
    }

    // 키 차이
    ArrayList<Integer> diff = new ArrayList<>();
    for (int i = 0; i < N - 1; i++) {
      diff.add(heights[i + 1] - heights[i]);
    }
    Collections.sort(diff);

    // 5명 3조 -> 2번 나누기
    // 8명 4조 -> 4번 나누기
    int cost = 0;
    for (int i = 0; i < N - K; i++) {
      cost += diff.get(i);
    }

    System.out.println(cost);
  }
}
