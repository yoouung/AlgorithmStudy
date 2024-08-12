import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] nlist = new int[N];
    for (int i = 0; i < N; i++) {
      nlist[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(nlist);

    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      int target = Integer.parseInt(st.nextToken());

      boolean isFound = findValue(target, nlist);
      System.out.println(isFound ? 1 : 0);
    }
  }
  
  static boolean findValue(int target, int[] list) {

    if (target < list[0] | target > list[list.length - 1]) {
      return false;
    }

    int start = 0;
    int end = list.length - 1;

    while (start <= end) {
      int current = (start + end) / 2;
      
      if (target == list[current]) {
        return true;
      } else if (target < list[current]) {
        end = current - 1;
      } else if (target > list[current]) {
        start = current + 1;
      }
    }

    return false;
  }
} 
