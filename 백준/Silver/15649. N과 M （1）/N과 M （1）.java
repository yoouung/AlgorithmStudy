import java.util.*;

public class Main {

  static int N, M;
  static int[] arr;
  static boolean[] visited;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();
    arr = new int[M];
    visited = new boolean[N];

    dfs(0);
    System.out.println(sb);
  }

  static void dfs(int depth) {
    if (depth == M) {
      for (int n : arr) {
        sb.append(n).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i=0; i<N; i++) {
      if (!visited[i]) {
        arr[depth] = i + 1;
        visited[i] = true;

        dfs(depth + 1);
        visited[i] = false;
      }
    }

  } 
}
