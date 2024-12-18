import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    StringBuilder sb = new StringBuilder();
    sb.append("<");

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 1; i <= N; i++) {
      queue.offer(i);
    }

    while (queue.size() != 1) {
      for (int i=0; i<K-1; i++) {
        queue.offer(queue.poll()); // 맨앞에꺼 빼서 맨 뒤로
      }
      sb.append(queue.poll()).append(", ");

    }

    sb.append(queue.poll()).append(">");
    System.out.println(sb.toString());
  }
}
