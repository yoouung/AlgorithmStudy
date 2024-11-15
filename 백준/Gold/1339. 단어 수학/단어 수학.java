import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  /*
  알파벳이랑 숫자 매칭 -> int[26] 배열 만들고, 인덱스 구할 땐 char - 'A'
   */

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] weight = new int[26];

    for (int i = 0; i < N; i++) {
      String input = br.readLine();
      for (int j = 0; j < input.length(); j++) {
        weight[input.charAt(j) - 'A'] += (int) Math.pow(10, input.length() - 1 - j);
      }
    }

    Arrays.sort(weight);
    int max = 9;
    int sum = 0;
    for (int i = 25; i>0; i--) {
      if (weight[i] == 0) break;
      
      sum += max * weight[i];
      max--;
    }

    System.out.println(sum);
  }
}
