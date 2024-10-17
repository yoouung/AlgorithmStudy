import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[] edgeCount = new int[N + 1];

    ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<Integer>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int first = Integer.parseInt(st.nextToken());
      int second = Integer.parseInt(st.nextToken());

      graph.get(first).add(second);
      edgeCount[second]++;
    }
    ;

    Queue<Integer> queue = new LinkedList<>();

    for (int i=1; i<=N; i++) { // 초기화
      if (edgeCount[i] == 0) {
        queue.add(i);
      }
    }

    while (!queue.isEmpty()) {
      int current = queue.poll();
      sb.append(String.valueOf(current) + " ");

      for (int i: graph.get(current)) {
        edgeCount[i] -= 1;
        if (edgeCount[i] == 0) {
          queue.add(i);
        }
      }
    }

    System.out.println(sb.toString());
  }
}
