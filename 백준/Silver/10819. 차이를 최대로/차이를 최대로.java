import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int[] numbers;
  static boolean[] visited;
  static ArrayList<Integer> changed = new ArrayList<>();
  static int max = Integer.MIN_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    numbers = new int[N];
    visited = new boolean[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }

    backtracking();
    System.out.println(max);
  }

  static void backtracking() {
    if (changed.size() == N) {
      max = Math.max(max, calculateResult());
    }

    for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        changed.add(numbers[i]);
        backtracking();
        visited[i] = false;
        changed.remove(changed.size()-1);
      }
    }
  }

  static int calculateResult() {
    int sum = 0;
    for (int i = 0; i < N - 1; i++) {
      sum += Math.abs(changed.get(i) - changed.get(i + 1));
    }
    return sum;
  }
}
