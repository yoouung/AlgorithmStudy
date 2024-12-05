import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
  static ArrayList<Long> numbers = new ArrayList<>();
  // long: 최대 9876543210인데 이는 int 범위를 초과

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    for (int i = 1; i <= 10; i++) {
      generate(0, i, 10);
    }

    Collections.sort(numbers);
    if (N >= numbers.size()) {
      System.out.println(-1);
    } else {
      System.out.println(numbers.get(N));
    }
  }

  static void generate(long current, int length, int lastNum) {
    // current: 현재 숫자
    // length: 자릿수
    // lastNum: 직전 자리의 숫자

    if (length == 0) {
      numbers.add(current);
      return;
    }

    for (int n = 0; n < lastNum; n++) {
      generate(current * 10 + n, length - 1, n);
    }
  }
}
