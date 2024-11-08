import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  /*
  중앙값 구하기 => 최대 힙, 최소 힙 각각 priority queue로 저장해서
  그때그때 중앙값과 비교해서 하나의 큐에 넣기
   */

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> bigger = new PriorityQueue<>(); // 중앙값보다 큰
    PriorityQueue<Integer> smaller = new PriorityQueue<>(Collections.reverseOrder()); // 중앙값보다 작거나 같은

    for (int i = 0; i < N; i++) {
      int current = Integer.parseInt(br.readLine());

      if (smaller.isEmpty() || smaller.peek() >= current) {
        smaller.offer(current);
      } else {
        bigger.offer(current);
      }

      if (smaller.size() > bigger.size() + 1) {
        bigger.offer(smaller.poll());
      } else if (smaller.size() < bigger.size()) {
        smaller.offer(bigger.poll());
      }

      System.out.println(smaller.peek());
    }
  }
}
