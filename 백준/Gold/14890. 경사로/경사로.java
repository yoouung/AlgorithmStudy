import java.util.*;
import java.io.*;

public class Main {
  /*
  경사로가 설치된 길에는 다른 경사로를 설치하지 못함 (but 가로, 세로는 독립적)
  ex) [3 2 2 3 2 2] 처럼 오르막과 내리막이 교차하는 경우
  -> installed[]로 설치 여부 추적

  처음 생각: dup[] 배열로 같은 높이의 층이 연속된 누적 수를 저장
  -> dup[n] <= L 인 경우 경사로 설치 가능
  ==> 단순히 연속된 L개의 층수만 검토하면 되기 때문에 dup 배열이 필요 없다...
  */

  static int N, L, count;
  static int[][] graph;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    graph = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < N; i++) {
      if (isPossible(graph[i])) { // 가로 길
        count++;
      }
      if (isPossible(vertical(i))) { // 세로 길
        count++;
      }
    }

    System.out.println(count);
  }

  static int[] vertical(int idx) {
    int[] re = new int[N];
    for (int i = 0; i < N; i++) {
      re[i] = graph[i][idx];
    }
    return re;
  }

  static boolean isPossible(int[] road) {
    boolean[] installed = new boolean[N];

    for (int i = 1; i < N; i++) {
      int diff = road[i] - road[i - 1]; // 높이 차이

      if (diff == 0) {
        continue;
      } else if (diff == 1) {
        for (int j = i - 1; j >= i - L; j--) {
          if (j < 0 || road[j] != road[i - 1] || installed[j]) {
            return false;
          }
          installed[j] = true;
        }
      } else if (diff == -1) {
        if (i + L > N) {
          return false;
        }
        for (int j = i; j < i + L; j++) {
          if (road[j] != road[i] || installed[j]) {
            return false;
          }
          installed[j] = true;
        }
        i += L - 1;
      } else { // 높이 차이가 2 이상이거나, 낮은 층 길이가 L보다 짧을 경우
        return false;
      }
    }
    return true;
  }
}
