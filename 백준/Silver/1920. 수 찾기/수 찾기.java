import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(br.readLine());
    int[] base = new int[N];
    String[] input = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      base[i] = Integer.parseInt(input[i]);
    }
    Arrays.sort(base);

    int M = Integer.parseInt(br.readLine());
    int[] targetNums = new int[M];
    String[] input2 = br.readLine().split(" ");
    for (int i = 0; i < M; i++) {
      targetNums[i] = Integer.parseInt(input2[i]);
    }

    for (int i = 0; i < M; i++) {
      int target = targetNums[i];

      int start = 0;
      int end = base.length - 1;
      boolean isExist = false;
      
      while (start <= end) {
        int mid = (start + end) / 2;

        if (base[mid] == target) {
          isExist = true;
          break;
        } else if (base[mid] < target) {
          start = mid + 1;
        } else {
          end = mid - 1;
        }
      }

      System.out.println(isExist ? 1 : 0);

    }
  } 
}
