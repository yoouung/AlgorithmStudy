import java.util.*;
import java.io.*;

public class Main {
  /*
  [에라토스테네스의 체] 특정 범위 내의 소수의 개수를 구하거나, 소수 목록을 구하는 알고리즘
  - p * q = N 일 때, p, q 중 하나는 반드시 루트N 보다 작거나 같다.
    : p가 커지면 q가 작아지고, p가 작아지면 q가 커지기 때문
    : 이 때 루트N 이하의 자연수 중에 나누어 떨어지는 수가 있다면 N은 소수가 아니다.
  - 시간 복잡도: O(Nlog(logN))
    : N까지 모든 소수 i에 대해 배수를 제거 = N/i번
    : 소수만 체크하면 되므로, 전체 소수들의 역수합은 log(logN)에 수렴한다.
   */

  static boolean[] isNotPrime; // 소수: false, 소수 아닌 수: true (소수 아닌 수를 판별하여 true로 변경하기 위해)
  static int N, M;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    isNotPrime = new boolean[N+1];

    checkPrime();

    StringBuilder sb = new StringBuilder();
    for (int i=M; i<=N; i++) {
      if (!isNotPrime[i]) {
        sb.append(i).append("\n");
      }
    }

    System.out.println(sb.toString());
  }

  static void checkPrime() {
    isNotPrime[0] = true;
    isNotPrime[1] = true;

    for (int i = 2; i<=Math.sqrt(N+1); i++) {
      if (isNotPrime[i]) continue;

      // i는 현재 소수, i의 배수인 수는 true로 변경
      // 2의 배수는 4부터, 3의 배수는 9부터(이미 6과 12는 2에서 변경됨 -> 9부터 시작하는게 효율적), ...
      for (int j=i * i; j<N+1; j += i) {
        isNotPrime[j] = true;
      }
    }
  }
}
