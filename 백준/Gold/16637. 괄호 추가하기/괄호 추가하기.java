import java.io.*;

public class Main {
  /*
  연산 최댓값 구하기: DFS와 백트레킹
  1) 현재 연산자 위치에서 다음 연산에 괄호가 없을 때
  2) 현재 연산자 위치에서 다음 연산에 괄호가 있을 때
   */

  static int N, result = Integer.MIN_VALUE;
  static int[] nums;
  static char[] ops;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    nums = new int[N / 2 + 1];
    ops = new char[N / 2];

    String st = br.readLine();
    for (int i = 0; i < N; i++) {
      if (i % 2 == 0) {
        nums[i / 2] = Integer.parseInt(String.valueOf(st.charAt(i)));
      } else {
        ops[i / 2] = st.charAt(i);
      }
    }

    dfs(0, nums[0]);
    System.out.println(result);
  }

  static void dfs(int idx, int current) {
    if (idx >= N / 2) {
      result = Math.max(result, current);
      return;
    }

    // 다음 연산에 괄호 없을 때
    int res1 = cal(ops[idx], current, nums[idx + 1]);
    dfs(idx + 1, res1);

    // 다음 연산에 괄호 있을 때
    if (idx + 1 < N / 2) { // 다음 계산식이 존재해야 한다.
      int inside = cal(ops[idx + 1], nums[idx + 1], nums[idx + 2]);
      int res2 = cal(ops[idx], current, inside);
      dfs(idx + 2, res2);
    }
  }

  static int cal(char op, int n1, int n2) {
    switch (op) {
      case '+': return n1 + n2;
      case '-': return n1 - n2;
      case '*': return n1 * n2;
      default: return -1;
    }
  }
}
