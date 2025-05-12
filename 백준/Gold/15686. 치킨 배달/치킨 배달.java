import java.util.*;
import java.io.*;

public class Main {
  /*
  M개의 치킨집을 조합으로 고르고 (백트레킹)
  그 치킨집들과의 최소 거리를 구하고, 그 최소 거리를 계속해서 비교

  백트레킹: solve(int start, int count) 함수에서 start 인수가 필수적이다.
  중복 조합이 허용 안되기 때문에, i번째 치킨집을 골랐다면 i+1 번째 치킨집들 중에서만 고를 수 있다.
   */

  static int N, M, answer;
  static int[][] graph;
  static boolean[] open;
  static List<int[]> houses = new ArrayList<>(), places = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    graph = new int[N][N];
    answer = Integer.MAX_VALUE;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
        if (graph[i][j] == 1) {
          houses.add(new int[] {i, j});
        } else if (graph[i][j] == 2) {
          places.add(new int[] {i, j});
        }
      }
    }

    open = new boolean[places.size()];

    solve(0, 0);
    System.out.println(answer);
  }

  static void solve(int start, int count) {
    if (count == M) {
      answer = Math.min(answer, calculateDistance());
      return;
    }

    for (int i = start; i < places.size(); i++) {
      if (!open[i]) {
        open[i] = true;
        solve(i + 1, count + 1);
        open[i] = false;
      }
    }
  }

  static int calculateDistance() {
    int sum = 0;
    for (int[] house : houses) {
      int minDistance = Integer.MAX_VALUE;
      for (int i = 0; i < places.size(); i++) {
        if (open[i]) {
          int[] place = places.get(i);
          int dis = Math.abs(house[0] - place[0]) + Math.abs(house[1] - place[1]);
          minDistance = Math.min(minDistance, dis);
          if (minDistance == 1) break; // 거리가 1이면 무조건 최소 거리
        }
      }
      sum += minDistance;
      if (sum >= answer) return sum; // 이미 최소가 아니면 중단
    }
    return sum;
  }
}
