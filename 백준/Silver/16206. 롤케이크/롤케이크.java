import java.util.*;
import java.io.*;

public class Main {

  /* 규칙 찾기
  20은 1번만 나눠도 10이 2개 생김
  30은 2번만 나눠도 10이 3개 생김
  -> 10의 배수가 나온다면 배수만큼 10이 생긴다.
  
  => 10의 배수인 수를 가장 먼저 해야 함
  
  ** andy 교수님의 강의
  - 같은 10의 배수여도 길이가 짧은 롤케이크 먼저 처리해야 한다.
  - M=2 일 때, 50 30 순서로 입력된 경우
    50 먼저: {50: 10/10/30, 30} -> 롤케이크 2개
    30 먼저: {30: 10/10/10, 50} -> 롤케이크 3개
    
  ** kevin 교수님의 강의
  - 우선순위 큐는 iterator 돌리면 순서 뒤죽박죽 된다.
  - for (int rollcake: rollcakes) {} 말고 .poll()해서 사용해야 한다
   */

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    // 10으로 나눈 나머지가 작은 순서대로 정렬
    // 10으로 나눈 나머지가 같다면 오름차순 정렬
    PriorityQueue<Integer> rollcakes = new PriorityQueue<>((l1, l2) -> {
      int mod1 = l1 % 10;
      int mod2 = l2 % 10;
      if (mod1 == mod2) {
        return Integer.compare(l1, l2);
      } else {
        return Integer.compare(mod1, mod2);
      }
    });

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      rollcakes.offer(Integer.parseInt(st.nextToken()));
    }

    int count = 0;
    while (!rollcakes.isEmpty()) {
      int rollcake = rollcakes.poll();
      
      if (rollcake < 10) {
        continue;
      } 
      
      while (rollcake >= 10 && M >= 0) {
        if (rollcake == 10) {
          count++;
          break;
        }

        if (M == 0) {
          break;
        }

        rollcake -= 10;
        count++; // 롤케이크 개수 추가
        M--; // 자를 수 있는 횟수 차감
      }

      if (M == 0) {
        break;
      }
    }

    System.out.println(count);
  }
}
