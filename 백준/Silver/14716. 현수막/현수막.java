import java.util.*;
import java.io.*;

public class Main {

  /*
   * dx, dy로 대각선 위치까지 탐색할 수 있게 하는게 관건이었던 것 같다.
   */

  static int M, N;
  static int[][] graph;
  static boolean[][] visited;
  static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 }; // 상하좌우 대각선
  static int[] dy = { 0, 0, 1, -1 , 1, -1, 1, -1};
  static int curX, curY;
  static int count = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    graph = new int[M][N];
    visited = new boolean[M][N];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				// 미방문이고 글자인 부분이면 탐색시작
				if(visited[i][j] == false && graph[i][j] == 1) {
					count++;
					bfs(i, j);
				}
			}
    }
      
    System.out.println(count);
  }
  
  static void bfs(int x, int y) {
    visited[x][y] = true;

    if (graph[x][y] == 0) {
      return;
    }

    for (int i = 0; i < 8; i++) {
      int newX = x + dx[i];
      int newY = y + dy[i];

      if (newX >= 0 && newX < M && newY >= 0 && newY < N) {
        if (!visited[newX][newY]) {
          bfs(newX, newY);
        }
      }
    }
  }
}
