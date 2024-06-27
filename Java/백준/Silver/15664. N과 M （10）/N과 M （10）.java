import java.util.*;
import java.io.*;

class Main {

  static int N, M;
  static boolean[] visited;
  static int[] numbers;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    numbers = new int[N];
    visited = new boolean[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(numbers);

    backtracing(0, 0, new ArrayList<Integer>());
    System.out.println(sb.toString());
  }
  
  static void backtracing(int start, int count, ArrayList<Integer> selected) {

    if (count == M) {
      for (int i = 0; i < M; i++) {
        sb.append(selected.get(i));

        if (i != selected.size() - 1) {
          sb.append(" ");
        }
      }
      sb.append("\n");
      return;
    }

    int before = -1;
    for (int i = start; i < N; i++) {
      if (!visited[i] && before != numbers[i]) { // 아직 방문하지 않았고 중복된 숫자가 아닐 경우에만
        visited[i] = true;
        selected.add(numbers[i]);
        before = numbers[i];
        backtracing(i + 1, count + 1, selected);

        selected.remove(selected.size() - 1);
        visited[i] = false;
      }
    }
  }
}