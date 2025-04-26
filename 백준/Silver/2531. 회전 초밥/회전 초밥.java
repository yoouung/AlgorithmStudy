import java.util.*;
import java.io.*;

public class Main {
  /*
  슬라이딩 윈도우, 투 포인터
  "연속한 k개의 접시를 고른다", 한 번에 전체를 다시 세지 않고 앞에서 하나 빼고, 뒤에 하나 더하는 식으로 효율적으로 구간을 업데이트
   */
  static int N, d, k, c;
  static int[] belt, count;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    belt = new int[N];
    for (int i=0; i<N; i++) {
      belt[i] = Integer.parseInt(br.readLine());
    }

    count = new int[d+1]; // 초밥 종류별 먹은 개수 기록
    System.out.println(slidingWindow());
  }

  static int slidingWindow() {
    int unique = 0;

    // 초기 윈도우 세팅
    for (int i=0; i<k; i++) {
      if (count[belt[i]] == 0) unique++;
      count[belt[i]]++;
    }

    int max = unique; // 최대 개수
    if (count[c] == 0) max++;

    // 윈도우 이동
    for (int i=1; i<N; i++) {
      // 맨앞 제거
      int remove = belt[i-1];
      count[remove]--;
      if (count[remove] == 0) unique--;

      // 맨뒤 추가
      int add = belt[(i+k-1) % N];
      if (count[add] == 0) unique++;
      count[add]++;

      // 쿠폰 적용
      int total = unique;
      if (count[c] == 0) total++;

      max = Math.max(max, total);
    }
    return max;
  }
}
