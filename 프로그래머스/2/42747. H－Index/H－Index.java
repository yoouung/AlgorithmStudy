import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int result = 0;
        Arrays.sort(citations);
        
        for (int i=0; i<citations.length; i++) {
            if (citations[i] >= citations.length - i) {
                result = Math.max(result, citations.length - i);
            }
        }
        return result;
    }
}