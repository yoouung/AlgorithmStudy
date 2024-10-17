import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        
        for (int i=0; i<commands.length; i++) {
            int[] current = commands[i];
            int[] tempArray = Arrays.copyOfRange(array, current[0]-1, current[1]);
            Arrays.sort(tempArray);
            result[i] = tempArray[current[2]-1];
        }
        
        return result;
    }
}