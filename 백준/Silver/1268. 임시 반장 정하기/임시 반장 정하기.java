import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] classes = new int[N + 1][5];
    Map<Integer, Set<Integer>> count = new HashMap<>();

    for (int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 5; j++) {
        classes[i][j] = Integer.parseInt(st.nextToken());
      }
      count.put(i, new HashSet<>());
    }

    for (int i = 0; i < 5; i++) {
      for (int j = 1; j < N; j++) {
        for (int k = j + 1; k <= N; k++) {
          if (classes[j][i] == classes[k][i]) {
            count.get(j).add(k);
            count.get(k).add(j);
          }
        }
      }
    }

    int max = 0;
    int president = 0;
    for (int i = N; i > 0; i--) {
      int size = count.get(i).size();
      if (max <= size) {
        max = size;
        president = i;
      }
    }
    System.out.println(president);
  }
}
