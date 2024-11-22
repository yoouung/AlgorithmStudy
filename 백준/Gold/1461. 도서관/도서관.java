import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static int M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();

    st = new StringTokenizer(br.readLine());
    int max = 0;
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      if (num < 0) {
        left.add(num);
      } else {
        right.add(num);
      }
      max = Math.max(Math.abs(num), max);
    }

    Collections.sort(left);
    Collections.sort(right, Comparator.reverseOrder());

    int dis;
    dis = distance(left) + distance(right) - max;

    System.out.println(dis);
  }

  static int distance(List<Integer> arr) {
    int total = 0;
    int len = arr.size();

    for (int i = 0; i < len; i = i + M) {
      total += arr.get(i) * 2;
    }

    return Math.abs(total);
  }
}
