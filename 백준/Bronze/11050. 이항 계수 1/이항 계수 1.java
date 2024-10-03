import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  /*
  이항계수 (n, k) = nCk => n! / (k!(n-k)!)
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    System.out.println(factorial(N) / (factorial(K) * factorial(N-K)));
  }

  static int factorial(int n) {
    if (n == 0) return 1;
    if (n == 1) return 1;

    return n * factorial(n-1);
  }
}
