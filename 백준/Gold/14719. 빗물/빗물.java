import java.util.*;
import java.io.*;

public class Main {
  /*
    빗물이 고이는 기준:
    1. 현재 블록의 높이보다 높은 블록이 왼쪽에 있어야 한다.
    2. 현재 블록의 높이보다 높은 블록이 오른쪽에 있어야 한다.
    3. 첫번째, 마지막 블록에는 빗물이 고일 수 없다.

    => left, right 변수에 왼쪽, 오른쪽 최대 블록 높이를 저장
       + 하나씩 탐색하면서 left, right 업데이트
         (H, W <= 500 이라 매번 for문 돌아도 괜찮음)
       + 현재 블록이 왼쪽, 오른쪽보다 작다면 -> 고인 빗물 계산
   */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] height = new int[W];
        for (int i=0; i<W; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int total = 0;
        for (int i=1; i<W-1; i++) {
            int left = 0, right = 0;

            for (int l=0; l<i; l++) {
                left = Math.max(left, height[l]);
            }
            for (int r=i+1; r<W; r++) {
                right = Math.max(right, height[r]);
            }

            if (height[i] < left && height[i] < right) {
                total += Math.min(left, right) - height[i];
            }
        }

        System.out.println(total);
    }
}
