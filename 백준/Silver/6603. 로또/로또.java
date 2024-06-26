import java.util.*;
import java.io.*;

public class Main {

  static int k;
  static ArrayList<Integer> numbers;
  static StringBuilder sb;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();

    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int isZero = Integer.parseInt(st.nextToken());
      if (isZero == 0) {
        break;
      }

      k = isZero;
      numbers = new ArrayList<>();
      visited = new boolean[k];

      for (int i = 0; i < k; i++) {
        numbers.add(Integer.parseInt(st.nextToken()));
      }

      match(0, 0, new ArrayList<Integer>());
      sb.append("\n");
    }

    System.out.println(sb.toString());
  }
  
  static void match(int start, int count, ArrayList<Integer> selected) {

    if (count == 6) {
      for (int i = 0; i < 6; i++) {
        sb.append(selected.get(i));
        if (i < selected.size() - 1) {
          sb.append(" ");
        }
      }
      sb.append("\n");
      return;
    }

    for (int i = start; i < k; i++) {
      if (!visited[i]) {
        visited[i] = true;
        selected.add(numbers.get(i));
        match(i + 1, count + 1, selected);
        selected.remove(selected.size() - 1);
        visited[i] = false;
      }
    }
  }
}
