import java.util.*;
import java.io.*;

public class Main {
  /*
  소수 목록 나열하고, 투포인터로 합이 N 되는 구간 찾기
  n이 2~루트n 의 모든 숫자로 나눠지지 않을 경우 n은 소수
  ex) 13: 2, 3 / 49: 2, 3, 4, 5, 6, 7(x)
   */

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    List<Integer> primes = new ArrayList<>(); // 소수 목록
    if (N == 1) {
      System.out.println(0);
      return;
    } else if (N == 2) {
      System.out.println(1);
      return;
    }

    // 합이 N이어야 한다면 소수 개수는 N보다 무조건 같거나 작음
    primes.add(2);
    for (int i = 3; i <= N; i++) {
      boolean isPrime = true;
      for (int j = 2; j <= Math.sqrt(i); j++) {
        if (i % j == 0) {
          isPrime = false;
          break;
        }
      }
      if (isPrime) primes.add(i);
    }

    int left = 0;
    int cur = 0;
    int count = 0;

    for (int right = 0; right < primes.size(); right++) {
      cur += primes.get(right);
      if (cur == N) {
        count++;
      }

      while (cur > N) {
        cur -= primes.get(left);
        left++;
        if (cur == N) count++;
      }
    }

    System.out.println(count);
  }
}
