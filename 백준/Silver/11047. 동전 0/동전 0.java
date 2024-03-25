
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 동전 종류
        int K = sc.nextInt(); // 합
        int[] values = new int[N];

        for (int i = 0; i < N; i++) {
            values[i] = sc.nextInt();
        }
        
        // 그리디 알고리즘
        // '뒤의 동전 가격 A가 앞에 나오는 동전 가격 Ai-1의 배수가 된다'
        int count = 0;

        for (int i = N-1; i >= 0; i--) {
            if (values[i] <= K) {
                count += K / values[i];
                K = K % values[i];
            }
        }

        System.out.println(count);
    }
}
