class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int bx = bill[0], by = bill[1];
        int wx = wallet[0], wy = wallet[1];
        while (Math.min(bx, by) > Math.min(wx, wy) || Math.max(bx, by) > Math.max(wx, wy)) {
            if (bx > by) {
                bx /= 2;
            } else {
                by /= 2;
            }
            answer += 1;
        }
        
        return answer;
    }
}