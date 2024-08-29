import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long X = Long.parseLong(st.nextToken());
    long Y = Long.parseLong(st.nextToken());
    long Z = Y * 100 / X ;

    if (Z >= 99) {
      System.out.println(-1);
      return;
    }

    long start = 1;
    long end = 1000000000;
    
    long result = -1;
    while (start <= end) {
      long mid = (start + end) / 2;
      long nx = X + mid;
      long ny = Y + mid;
      long nz =  ny * 100/ nx ;

      if (nz > Z) {
        end = mid - 1;
        result = mid;
      } else {
        start = mid + 1;
      }

    }

    System.out.println(result);
  } 
}
