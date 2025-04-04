// 이진탐색
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int n = diffs.length;
        
        int start = 1;
        int end = 0;
        for (int d: diffs) {
            end = Math.max(end, d);
        }
        int answer = end;
        
        while (start <= end) {
            int mid = (start + end) / 2;  
            
            if (canClear(diffs, times, limit, mid)) {
                end = mid - 1;
                answer = mid;
            } else {
                start = mid + 1;
            }
        }
        
        
        return answer;
        
    }
    
    static boolean canClear(int[] diffs, int[] times, long limit, int level) {
        long totalTime = times[0]; // 첫 문제는 무조건 해결 가능

        for (int i = 1; i < diffs.length; i++) {
            int diff = diffs[i];
            int cur = times[i];
            int prev = times[i - 1];
            
            if (diff > level) {
                totalTime += (long)(diff - level) * (cur + prev);
            }

            totalTime += cur;

            if (totalTime > limit) return false;
        }

        return true;
    }
}

// 시간복잡도 터진 코드
// class Solution {
//     public int solution(int[] diffs, int[] times, long limit) {
//         int n = diffs.length;

//         int maxDiff = 0;
//         for (int d : diffs) {
//             maxDiff = Math.max(maxDiff, d);
//         }

//         for (int level = 1; level <= maxDiff; level++) {
//             long time = times[0]; // 첫 번째 문제는 무조건 해결

//             for (int i = 1; i < n; i++) {
//                 int diff = diffs[i];
//                 int cur = times[i];
//                 int prev = times[i - 1];

//                 long penalty = Math.max(diff - level, 0L) * (cur + prev);
//                 time += penalty + cur;

//                 if (time > limit) break;
//             }

//             if (time <= limit) return level;
//         }

//         return maxDiff;
//     }
// }


// 공간복잡도 터진 코드
// import java.util.*;

// class Solution {
//     /*
//       첫번째 인덱스는 무조건 바로 해결 가능
//       (해결 못하면 time_prev 필요한데 안주어지기 때문에 불가능)
//      */
//     public int solution(int[] diffs, int[] times, long limit) {
//         int n = diffs.length;
        
//         int maxDiff = 0;
//         for (int i: diffs) {
//             maxDiff = Math.max(maxDiff, i);
//         }
        
//         long[][] dp = new long[maxDiff][n];
//         for (int i=0; i<maxDiff; i++) {
//             dp[i][0] = (long) times[0];
//         }
        
//         for (int i=0; i<maxDiff; i++) {
//             int level = i+1;
            
//             for (int j=1; j<n; j++) {
//                 int diff = diffs[j];
//                 int cur = times[j];
//                 int prev = times[j-1];
            
//                 dp[i][j] = dp[i][j-1] + (Math.max(diff - level, 0))*(cur+prev) + cur;
//             }
            
//             if (dp[i][n-1] <= limit) {
//                 return i+1;
//             }
//         }
        
//         return maxDiff;
//     }
// }