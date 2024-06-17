import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int count = 0;

    while (n > 0) {
      // 5원
      if (n % 5 == 0) {
        count += n / 5;
        n = 0;
        break;
      } 

      // 2원
      n -= 2;
      count++;
    }
    
    if (n == 0) {
      System.out.println(count);
    } else {
      System.out.println(-1);
    }
  }
}