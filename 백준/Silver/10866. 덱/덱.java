import java.util.*;
import java.io.*;

public class Main {
  /*
   */

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Deque<Integer> deque = new LinkedList<>();

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String comment = st.nextToken();
      switch (comment) {
        case "push_front":
          deque.offerFirst(Integer.parseInt(st.nextToken()));
          break;
        case "push_back":
          deque.offer(Integer.parseInt(st.nextToken()));
          break;
        case "pop_front":
          System.out.println(deque.isEmpty() ? -1 : deque.pollFirst());
          break;
        case "pop_back":
          System.out.println(deque.isEmpty() ? -1 : deque.pollLast());
          break;
        case "size":
          System.out.println(deque.size());
          break;
        case "empty":
          System.out.println(deque.isEmpty() ? 1 : 0);
          break;
        case "front":
          System.out.println(deque.isEmpty() ? -1 : deque.getFirst());
          break;
        case "back":
          System.out.println(deque.isEmpty() ? -1 : deque.getLast());
          break;
      }
    }
  }
}
