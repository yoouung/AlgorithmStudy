class Solution {
    public int solution(int[][] triangle) {
        int depth = triangle.length;
        int[][] dp = new int[depth][depth];
        
        dp[0][0] = triangle[0][0];
        // 가장 왼쪽은 우선 저장
        // 두번째 for문에서 j>=1 하려면 필요하다. j>=0으로 하면 arrayoutofindex에러
        for (int i=1; i<depth; i++) {
            dp[i][0] = dp[i-1][0] + triangle[i][0];
        }
        
        for (int i=1; i<depth; i++) {
            for (int j=1; j<triangle[i].length; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1] + triangle[i][j], dp[i-1][j] + triangle[i][j]);
            }
        }
        
        int max = 0;
        for (int i=0; i<depth; i++) {
            max = Math.max(dp[depth-1][i], max);
        }
        
        return max;
    }
}