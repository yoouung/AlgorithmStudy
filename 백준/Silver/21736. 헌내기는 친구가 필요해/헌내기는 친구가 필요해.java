import java.util.*;
import java.io.*;

public class Main {

  static int N, M;
  static char[][] graph;
  static boolean[][] visited;
  static int[] dx = { 1, -1, 0, 0 };
  static int[] dy = { 0, 0, 1, -1 };

  static int ix, iy;
  static int count = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    graph = new char[N][M];
    visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < M; j++) {
        graph[i][j] = line.charAt(j);

        if (graph[i][j] == 'I') {
          ix = i;
          iy = j;
        }
      }
    }

    bfs(ix, iy);

    if (count == 0) {
      System.out.println("TT");
    } else {
      System.out.println(count);
    }

  }
  
  static void bfs(int x, int y) {
    visited[x][y] = true;

    if (graph[x][y] == 'P') {
      count++;
    } else if (graph[x][y] == 'X') {
      return;
    }

    for (int i = 0; i < 4; i++) {
      int newX = x + dx[i];
      int newY = y + dy[i];

      if (newX >= 0 && newX < N && newY >= 0 && newY < M) {
        if (!visited[newX][newY]) {
          bfs(newX, newY);
        }
      }
    }
  }
    
}
  