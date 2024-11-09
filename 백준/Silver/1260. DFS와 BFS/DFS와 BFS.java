import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static int N, M, V;
  static ArrayList<Integer>[] graph;
  static boolean[] visited;
  static Stack<Integer> stack = new Stack<>();
  static Queue<Integer> queue = new LinkedList<>();
  static StringBuilder dfs_sb = new StringBuilder();
  static StringBuilder bfs_sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    V = Integer.parseInt(st.nextToken());
    graph = new ArrayList[N + 1];
    visited = new boolean[N + 1];

    for (int i = 0; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int first = Integer.parseInt(st.nextToken());
      int second = Integer.parseInt(st.nextToken());
      graph[first].add(second);
      graph[second].add(first);
    }

    for (int i = 0; i <= N; i++) {
      Collections.sort(graph[i]);
    }

    stack.push(V);
    dfs();

    visited = new boolean[N + 1];
    bfs(V);

    System.out.println(dfs_sb.toString());
    System.out.println(bfs_sb.toString());
  }

  static void dfs() {
    int current = stack.pop();
    visited[current] = true;
    dfs_sb.append(current).append(" ");

    for (int next : graph[current]) {
      if (!visited[next]) {
        stack.push(next);
        dfs();
      }
    }
  }

  static void bfs(int index) {
    queue.offer(index);
    visited[index] = true;

    while (!queue.isEmpty()) {
      int current = queue.poll();
      bfs_sb.append(current).append(" ");

      for (int next : graph[current]) {
        if (!visited[next]) {
          queue.offer(next);
          visited[next] = true;
        }
      }
    }
  }
}
