import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int countZero = 0;
        int countChange = 0;
        String current = new String(s);
        
        while (countChange < 4) {
            int countOne = 0;
            
            for (int i=0; i < current.length(); i++) {
                if (current.charAt(i) == '0') {
                    countZero++;
                } else {
                    countOne++;
                }
            }
            current = Integer.toBinaryString(countOne);
            System.out.println("countOne: " + countOne + "current: " + current);
            countChange++;
            System.out.println(current.equals("1"));
        }
        
        // answer[0] = countChange;
        // answer[1] = countZero;
        return answer;
    }
}