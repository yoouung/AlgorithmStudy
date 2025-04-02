class Solution {
    public int solution(int[] players, int m, int k) {
        int[] server = new int[players.length+k];
        int count = 0;
        
        for (int i=0; i<players.length; i++) {
            int current = players[i];
            int need = current / m;
            
            if (need <= server[i]) {
                continue;
            }
            
            int add = need - server[i];
            for (int j=i; j<i+k; j++) {
                server[j] += add;
            }
            
            count += add;
            
        }
        
        
        return count;
    }
}