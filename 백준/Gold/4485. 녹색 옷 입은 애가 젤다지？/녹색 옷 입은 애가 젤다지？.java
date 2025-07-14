import java.util.*;
import java.io.*;

public class Main {
  /*
  다익스트라 알고리즘
  - 우선순위 큐: 현재 노드로부터 다른 노드까지의 거리 리스트
   */

  static class Node implements Comparable<Node> {
    int x, y, w;

    Node(int x, int y, int w) {
      this.x = x;
      this.y = y;
      this.w = w;
    }

    public int compareTo(Node o) {
      return this.w - o.w;
    }
  }

  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
  static int N;
  static int[][] coins, sum;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int count = 1;

    while (true) {
      N = Integer.parseInt(br.readLine());
      if (N == 0) break;

      coins = new int[N][N];
      sum = new int[N][N];

      for (int i = 0; i < N; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
          coins[i][j] = Integer.parseInt(st.nextToken());
          sum[i][j] = Integer.MAX_VALUE;
        }
      }

      sum[0][0] = coins[0][0];
      bfs();
      sb.append("Problem ").append(count++).append(": ").append(sum[N - 1][N - 1]).append("\n");
    }
    System.out.println(sb);
  }

  static void bfs() {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(0, 0, coins[0][0]));

    while (!pq.isEmpty()) {
      Node current = pq.poll();
      int cx = current.x;
      int cy = current.y;
      int cw = current.w;

      for (int i = 0; i < 4; i++) {
        int nx = cx + dx[i];
        int ny = cy + dy[i];
        if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
          if (cw + coins[nx][ny] < sum[nx][ny]) {
            // 다음 노드의 최저 코인 개수가 현재 코인 개수 + 다음 노드의 코인 개수보다 클 때만
            // 1. 최저 코인 개수 배열 sum 업데이트
            // 2. pq에 다음 노드 추가: sum 업데이트 되었으니까 다음 노드에서 다른 노드들의 거리(코인)를 다시 구해야 함
            sum[nx][ny] = cw + coins[nx][ny];
            pq.offer(new Node(nx, ny, sum[nx][ny]));
          }
        }
      }
    }
  }
}