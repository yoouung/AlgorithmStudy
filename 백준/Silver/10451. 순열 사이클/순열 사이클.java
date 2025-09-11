import java.util.*;
import java.io.*;

public class Main {
  /*
   */


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int t=0; t<T; t++) {
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N+1];
        boolean[] visited = new boolean[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int i=1; i<=N; i++) {
            if (visited[i]) {
                continue;
            }
            count++;
            dfs(nums, visited, i);
        }

        System.out.println(count);
    }
  }

  static void dfs(int[] nums, boolean[] visited, int current) {
      if (visited[current]) {
          return;
      }

      visited[current] = true;
      dfs(nums, visited,nums[current]);
  }
}
