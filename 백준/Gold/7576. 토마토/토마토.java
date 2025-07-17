import java.util.*;
import java.io.*;

public class Main {
  /*
  다익스트라
  - 출발점 여러개 -> visited
  - 입력값 받을 때 1, -1인 경우를 모두 저장하므로 graph 배열이 필요없다. 저장되지 않은 좌표는 모두 0인 것.
  */

  static class Node implements Comparable<Node> {
    int x, y, date;

    Node(int x, int y, int date) {
      this.x = x;
      this.y = y;
      this.date = date;
    }

    public int compareTo(Node o) {
      return Integer.compare(this.date, o.date);
    }
  }

  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());
    List<int[]> mature = new ArrayList<>();
    List<int[]> none = new ArrayList<>();

    boolean alreadyMature = true;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        int t = Integer.parseInt(st.nextToken());
        if (t == 1) {
          mature.add(new int[] {i, j});
        } else if (t == -1) {
          none.add(new int[] {i, j});
        } else if (t == 0 && alreadyMature) {
          alreadyMature = false;
        }
      }
    }

    if (alreadyMature) {
      System.out.println(0);
      return;
    }

    int[][] dist = dijkstra(mature, none, n, m);
    int maxDist = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (dist[i][j] == Integer.MAX_VALUE) {
          System.out.println(-1);
          return;
        }
        maxDist = Math.max(maxDist, dist[i][j]);
      }
    }
    System.out.println(maxDist);
  }

  static int[][] dijkstra(List<int[]> startIdxs, List<int[]> nones, int n, int m) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    int[][] dist = new int[n][m];
    boolean[][] visited = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dist[i], Integer.MAX_VALUE);
    }

    for (int[] none : nones) {
      dist[none[0]][none[1]] = 0;
    }
    for (int[] startIdx : startIdxs) {
      int x = startIdx[0];
      int y = startIdx[1];
      pq.offer(new Node(x, y, 0));
      dist[x][y] = 0;
    }

    while (!pq.isEmpty()) {
      Node currentNode = pq.poll();
      int cx = currentNode.x;
      int cy = currentNode.y;
      int cdate = currentNode.date;

      if (visited[cx][cy]) continue;
      visited[cx][cy] = true;

      for (int i = 0; i < 4; i++) {
        int nx = cx + dx[i];
        int ny = cy + dy[i];
        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
          if (cdate + 1 < dist[nx][ny]) {
            dist[nx][ny] = cdate + 1;
            pq.offer(new Node(nx, ny, dist[nx][ny]));
          }
        }
      }
    }
    return dist;
  }
}