import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int countZero = 0;
        int countChange = 0;
        String current = new String(s);
        
        while (!current.equals("1")) {
            int countOne = 0;
            
            for (int i=0; i < current.length(); i++) {
                if (current.charAt(i) == '0') {
                    countZero++;
                } else {
                    countOne++;
                }
            }
            current = Integer.toBinaryString(countOne);
            countChange++;
        }
        
        answer[0] = countChange;
        answer[1] = countZero;
        return answer;
    }
}