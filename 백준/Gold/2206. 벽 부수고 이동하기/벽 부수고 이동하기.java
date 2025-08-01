import java.util.*;
import java.io.*;

public class Main {
  /*
  1. 첫번째 시도: 백트레킹
  - 시간복잡도: O(4^(N*M))
  => 시간 초과 (같은 위치라도 남은 벽 개수가 다르면 다른 선택지 존재 → 중복 탐색 발생)
  ---
  2. BFS + visited 3차원배열 (남은 벽 개수를 배열에서 관리)
  - 시간복잡도: O(N*M*K)
  - 같은 위치라도 "어떤 상태로 왔는지"가 중요한 경우 3차원 배열이 필요하다.

  char to int: char - '0'
   */

  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, 1, -1};
  static int N, M;
  static char[][] graph;
  static boolean[][][] visited; // [x][y][남은 벽 개수]
  static int count = 1;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    graph = new char[N][M];
    visited = new boolean[N][M][2];

    for (int i = 0; i < N; i++) {
      graph[i] = br.readLine().toCharArray();
    }

    System.out.println(bfs());
  }

  static int bfs() {
    Queue<Node> queue = new LinkedList<>();
    queue.offer(new Node(0, 0, 1, 1));
    visited[0][0][0] = true;
    visited[0][0][1] = true;

    while (!queue.isEmpty()) {
      Node current = queue.poll();
      int cx = current.x;
      int cy = current.y;
      int cc = current.count;
      int cw = current.wallsLeft;

      if (cx == N - 1 && cy == M - 1) {
        return current.count;
      }

      for (int i = 0; i < 4; i++) {
        int nx = cx + dx[i];
        int ny = cy + dy[i];
        if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
          if (graph[nx][ny] == '0' && !visited[nx][ny][cw]) {
            visited[nx][ny][cw] = true;
            queue.offer(new Node(nx, ny, cc + 1, cw));
          } else if (graph[nx][ny] == '1' && cw > 0 && !visited[nx][ny][0]) {
            visited[nx][ny][0] = true;
            queue.offer(new Node(nx, ny, cc + 1, 0));
          }
        }
      }
    }
    return -1;
  }

  static class Node {
    int x, y, count, wallsLeft;

    public Node(int x, int y, int count, int wallsLeft) {
      this.x = x;
      this.y = y;
      this.count = count;
      this.wallsLeft = wallsLeft;
    }
  }
}
