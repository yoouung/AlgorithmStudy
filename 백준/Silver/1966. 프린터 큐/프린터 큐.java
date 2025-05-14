import java.util.*;
import java.io.*;

public class Main {
  /*
  가장 앞 요소를 poll -> 남아있는 모든 요소와 비교
  => 더 큰 중요도가 있다면 offer, 없다면 그대로 유지
   */

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int t=0; t<T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      Deque<Document> docs = new LinkedList<>();

      st = new StringTokenizer(br.readLine());
      for (int i=0; i<N; i++) {
        docs.offer(new Document(Integer.parseInt(st.nextToken()), i));
      }

      int count = 1;
      while (!docs.isEmpty()) {
        Document headDoc = docs.poll();
        boolean print = true;

        for (Document d: docs) {
          if (headDoc.priority < d.priority) { // 더 큰 중요도가 있을 때
            docs.offer(headDoc);
            print = false;
            break;
          }
        }

        if (print) {
          if (headDoc.index == M) {
            System.out.println(count);
          }
          count++;
        }
      }
    }
  }

  static class Document{
    int priority, index;

    public Document(int priority, int index) {
      this.priority = priority;
      this.index = index;
    }
  }
}
