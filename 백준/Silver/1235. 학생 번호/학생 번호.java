import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String[] arr = new String[N];
    int len = 100;

    for (int i = 0; i < N; i++) {
      arr[i] = br.readLine();
      len = arr[i].length();
    }

    for (int k = 1; k < 101; k++) {
      HashSet<String> tempSet = new HashSet<>();
      
      for (int i = 0; i < N; i++) {
        String temp = arr[i].substring(len - k);

        if (tempSet.contains(temp)) {
          break;
        } else {
          tempSet.add(temp);
          
          if (i == N - 1) {
            System.out.println(k);
            System.exit(0);
          }
        }
      }
    }
    
  }
}
