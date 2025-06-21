import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());

    PriorityQueue<Integer> fruits = new PriorityQueue<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      fruits.offer(Integer.parseInt(st.nextToken()));
    }

    while (!fruits.isEmpty()) {
      int fruit = fruits.poll();
      if (L >= fruit) {
        L++;
      }
    }

    System.out.println(L);
  }
}
