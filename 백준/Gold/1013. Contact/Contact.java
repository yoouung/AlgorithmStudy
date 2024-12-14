import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String regex = "(100+1+|01)+";

    int T = Integer.parseInt(br.readLine());
    for (int i=0; i<T; i++) {
      String line = br.readLine();
      if (line.matches(regex)) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }
}
