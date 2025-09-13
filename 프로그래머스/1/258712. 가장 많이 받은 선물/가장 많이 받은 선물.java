class Solution {
    public int solution(String[] friends, String[] gifts) {
        int people = friends.length;
        int[][] counts = new int[people][people]; // 주고받은 선물
        int[] diff = new int[people]; // 선물 지수
        for (String gift: gifts) {
            int from = getIndexOf(friends, gift.split(" ")[0]);
            int to = getIndexOf(friends, gift.split(" ")[1]);
            counts[from][to]++;
            diff[from]++;
            diff[to]--;
        }
        
        int[] nextMonth = new int[people]; // 다음달에 받을 선물 수
        for (int i=0; i<people; i++) {
            for (int j=0; j<people; j++) {
                if (i==j) continue;
                if ((counts[i][j] == counts[j][i] && diff[i] > diff[j]) 
                    || counts[i][j] > counts[j][i]) {
                    nextMonth[i]++;
                }
            }
        }
        
        int max = 0;
        for (int count:nextMonth) {
            max = Math.max(count, max);
        }
        return max;
    }
    
    static int getIndexOf(String[] friends, String name) {
        for (int i=0; i<friends.length; i++) {
            if (name.equals(friends[i])) {
                return i;
            }
        }
        return 0;
    }
}