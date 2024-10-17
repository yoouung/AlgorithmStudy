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
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    int[] edgeCount = new int[N + 1];

    ArrayList<Node>[] graph = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int X = Integer.parseInt(st.nextToken()); // 중간 부품 혹은 완제품 번호
      int Y = Integer.parseInt(st.nextToken()); // 필요한 부품 번호
      int need = Integer.parseInt(st.nextToken()); // 필요한 부품의 개수
      graph[X].add(new Node(Y, need));
      edgeCount[Y]++; // X 부품의 진입 차수 증가
    }

    Queue<Node> queue = new LinkedList<>();
    int[] counts = new int[N + 1];
    queue.offer(new Node(N, 1));
    counts[N] = 1;

    while (!queue.isEmpty()) {
      Node currentNode = queue.poll();

      for (Node nextNode : graph[currentNode.part]) {
        counts[nextNode.part] += counts[currentNode.part] * nextNode.count;
        edgeCount[nextNode.part]--;

        if (edgeCount[nextNode.part] == 0) {
          queue.add(nextNode);
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int i=1; i<=N; i++) {
      if (graph[i].isEmpty()) {
        sb.append(i).append(" ").append(counts[i]).append("\n");
      }
    }
    System.out.println(sb.toString());
  }
}

class Node {
  int part; // 부품 번호
  int count; // 필요한 개수

  // 생성자
  public Node(int part, int count) {
    this.part = part;
    this.count = count;
  }
}
