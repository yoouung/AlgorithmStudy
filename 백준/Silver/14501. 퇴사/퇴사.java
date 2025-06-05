import java.util.*;
import java.io.*;

public class Main {
  /*
  dp....? 냅색...?
  이전 상담 다 돌아보면서 현재 날짜까지 가능한 상담비 계산
  */

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] time = new int[N + 1];
    int[] pay = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      time[i] = Integer.parseInt(st.nextToken());
      pay[i] = Integer.parseInt(st.nextToken());
    }

    int[] max = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      max[i] = max[i - 1];
      for (int j = 1; j <= i; j++) {
        if (j + time[j] == i + 1) { // 당일 상담 가능한 경우까지
          max[i] = Math.max(max[j - 1] + pay[j], max[i]);
        }
      }
    }

    System.out.println(max[N]);
  }
}
