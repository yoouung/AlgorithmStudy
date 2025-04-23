import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int d = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] dpA = new int[d+1];
    int[] dpB = new int[d+1];

    dpA[1] = 1;
    dpB[2] = 1;
    for (int i=3; i<=d; i++) {
      dpA[i] = dpA[i-2] + dpA[i-1];
      dpB[i] = dpB[i-2] + dpB[i-1];
    }

    for (int f=1; f<100000; f++) {
      if ((k-(dpA[d]*f)) % dpB[d] == 0) {
        System.out.println(f);
        System.out.println((k-(dpA[d]*f)) / dpB[d]);
        return;
      }
    }
  }
}
