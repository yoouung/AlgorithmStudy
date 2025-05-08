import java.util.*;
import java.io.*;

public class Main {
  /*
  1부터 N까지 자연수 중에서 M개를 고른 수열
   */
  static int N, M;
  static Deque<Integer> deque = new LinkedList<>();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    backtracking(0, 1);
    System.out.println(sb.toString());
  }

  static void backtracking(int depth, int current) {
    if (depth == M) {
      for (Integer i: deque) {
        sb.append(i).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i=1; i<=N; i++) {
      deque.offer(i);
      backtracking(depth+1, i);
      deque.pollLast();
    }
  }
}
