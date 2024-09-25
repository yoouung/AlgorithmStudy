import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    long[] t = new long[36];

    t[0] = 1;
    t[1] = 1;
    if (N == 0 || N == 1) {
      System.out.println(t[N]);
      System.exit(0);
    }

    for (int i = 2; i <= N; i++) {
      for (int j = 0; j < i; j++) {
        t[i] += t[j] * t[i - j - 1];
      }
    }
    System.out.println(t[N]);
  }
}
