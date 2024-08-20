
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  static ArrayList<Integer>[] graph;
  static boolean[] visited;
  static int count = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    visited = new boolean[N + 1]; 
    graph = new ArrayList[N + 1];

    for (int i = 0; i < N + 1; i++) { // 각 노드별 리스트 초기화
      graph[i] = new ArrayList<>();
    }
    
    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int first = Integer.parseInt(st.nextToken());
      int second = Integer.parseInt(st.nextToken());

      graph[first].add(second);
      graph[second].add(first);
    }

    dfs(1);
    System.out.println(count -1);
  }
  
  static void dfs(int node) {
    if (visited[node]) {
      return;
    }

    visited[node] = true;
    count++;

    for (int i : graph[node]) {
      if (!visited[i]) {
        dfs(i);
      }
    }
  }
}
