import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] str = br.readLine().toCharArray();
    int zero = 0, one = 0;
    if (str[0] == '1') {
      one++;
    } else {
      zero++;
    }

    for (int i=1; i<str.length; i++) {
      if (str[i] != str[i-1]) {
        if (str[i] == '1') {
          one++;
        } else {
          zero++;
        }
      }
    }
    System.out.println(Math.min(one, zero));
  }
}
