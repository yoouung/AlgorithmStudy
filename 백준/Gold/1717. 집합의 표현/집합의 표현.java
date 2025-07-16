import java.util.*;
import java.io.*;

public class Main {
  /*
  유니온 파인드 알고리즘
  - 두 원소가 연결되어 있는지 판별
  === 시간초과
  parent[x] = find(parent[x]); -> 대표노드까지의 경로 압축
   */

  static int[] parent;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    parent = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      parent[i] = i; // 초기화 필수
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int comment = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      if (comment == 0) {
        union(x, y);
      } else {
        sb.append(find(x) == find(y) ? "YES" : "NO").append("\n");
      }
    }
    System.out.println(sb);
  }

  static void union(int x, int y) {
    int parentX = find(x);
    int parentY = find(y);
    if (parentX != parentY) {
      parent[parentX] = parent[parentY];
    }
  }

  static int find(int x) {
    if (parent[x] == x) return x;
    return parent[x] = find(parent[x]); // 경로 압축 필수 -> 시간 효율
  }
}
