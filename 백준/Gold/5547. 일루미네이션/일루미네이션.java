import java.util.*;
import java.io.*;

public class Main {
  /*
  BFS
  - 바깥에 테두리 영억을 추가하고, 0인 영역이 1인 영역과 맞닿아 있는 부분의 개수를 구하면 될 거라 생각함
  - H가 홀수, 짝수일 때 dx, dy가 달라짐 -> 따로 설정, 대각선도 가능함
  */

  static int[][] graph;
  static int[] dx1 = {1, -1, 0, 0, 1, -1}, dy1 = {0, 0, 1, -1, 1, 1}; // W가 홀수일 때
  static int[] dx2 = {1, -1, 0, 0, 1, -1}, dy2 = {0, 0, 1, -1, -1, -1}; // W가 짝수일 때
  static int W, H;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    H = Integer.parseInt(st.nextToken()); // W, H switch
    W = Integer.parseInt(st.nextToken());
    graph = new int[W + 2][H + 2];

    for (int i = 1; i <= W; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= H; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int result = bfs();
    System.out.println(result);
  }

  static int bfs() {
    int count = 0;
    boolean[][] visited = new boolean[W + 2][H + 2];
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[] {0, 0});

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int cx = current[0];
      int cy = current[1];
      int[] dx = cx % 2 == 0 ? dx2 : dx1;
      int[] dy = cx % 2 == 0 ? dy2 : dy1;

      for (int i = 0; i < 6; i++) {
        int nx = cx + dx[i];
        int ny = cy + dy[i];
        if (nx >= 0 && nx < W + 2 && ny >= 0 && ny < H + 2) {
          if (graph[nx][ny] == 1) {
            count++;
          } else if (!visited[nx][ny]) {
            visited[nx][ny] = true;
            queue.offer(new int[] {nx, ny});
          }
        }
      }
    }

    return count;
  }
}