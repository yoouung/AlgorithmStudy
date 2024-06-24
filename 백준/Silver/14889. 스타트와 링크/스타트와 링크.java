import java.util.*;
import java.io.*;

public class Main {

  static int N;
  static int[][] stats;
  static boolean[] visited;

  static int min = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    stats = new int[N][N];
    visited = new boolean[N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        stats[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    backtracking(0, 0);
    System.out.println(min);

  }
  
  static void backtracking(int index, int depth) {
    if (depth == N / 2) {
      min = Math.min(diff(), min);

      if (min == 0) {
        return;
      }
    }

    for (int i = index; i < N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        backtracking(i + 1, depth + 1);
        visited[i] = false; // 방문 이후에는 다시 비방문 처리
      }
    }

  }
  
  // 두 팀의 능력치 차이 계산
  static int diff() {

    int startTeam = 0;
    int linkTeam = 0;

    for (int i = 0; i < N; i++) {
      for (int j = i + 1; j < N; j++) {
        if (visited[i] && visited[j]) {
          startTeam += stats[i][j];
          startTeam += stats[j][i];
        } else if (!visited[i] && !visited[j]) {
          linkTeam += stats[i][j];
          linkTeam += stats[j][i];
        }
      }
    }

    return Math.abs(startTeam - linkTeam); // 절댓값
  }
}
