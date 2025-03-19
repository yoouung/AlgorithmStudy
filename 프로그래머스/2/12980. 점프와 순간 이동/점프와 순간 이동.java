import java.util.*;

public class Solution {
    public int solution(int n) {
        int count = 0;
        
        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
                count++;
            }
        }
        
        return count;
    }
    
    // dp: 시간복잡도 O(n), 공간복잡도 O(n) - 시간, 메모리 초과
//     public int solution(int n) {
//         int[] dp = new int[n+1];
//         Arrays.fill(dp, Integer.MAX_VALUE);
//         dp[0] = 0;
        
//         for (int i=1; i<n+1; i++) {
//             if (i % 2 == 0) {
//                 dp[i] = Math.min(dp[i-1] + 1, dp[i/2]);
//             } else { // 홀수인 위치는 순간이동해서 이동할 수가 없음
//                 dp[i] = Math.min(dp[i], dp[i-1] + 1);
//             }
//         }
        
//         return dp[n];
//     }
}