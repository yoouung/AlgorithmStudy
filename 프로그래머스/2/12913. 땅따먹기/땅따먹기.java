class Solution {
    int solution(int[][] land) {
        int length = land.length;
        int[][] dp = new int[length][4];
        
        // 첫 번째 행 초기화
        for (int j = 0; j < 4; j++) {
            dp[0][j] = land[0][j];
        }
        
        for (int i=1; i<length; i++) {
            for (int j=0; j<4; j++) {
                int max = 0;
                for (int k=0; k<4; k++) {
                    if (j == k) continue;
                    max = Math.max(dp[i-1][k], max);
                }
                dp[i][j] = max + land[i][j];
            }
        }
        
        int totalMax = 0;
        for (int i=0; i<4; i++) {
            totalMax = Math.max(totalMax, dp[length-1][i]);
        }
        

        return totalMax;
    }
}