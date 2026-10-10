class Solution {
    public int[] solution(int[] answers) {
        int[] res = {};
        int[] pat1 = {1, 2, 3, 4, 5}; // len = 5
        int[] pat2 = {2, 1, 2, 3, 2, 4, 2, 5}; // len = 8
        int[] pat3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // len = 10
            
        int[] correct = new int[3];
        for (int i=0; i<answers.length; i++) {
            int answer = answers[i];
            if (pat1[i%5] == answer) correct[0]++;
            if (pat2[i%8] == answer) correct[1]++;
            if (pat3[i%10] == answer) correct[2]++;
        }
        
        return findMax(correct);
    }
    
    static int[] findMax(int[] correct) {
        int max = Math.max(correct[0], Math.max(correct[1], correct[2]));
        int count = 0;
        if (correct[0] == max) count++;
        if (correct[1] == max) count++;
        if (correct[2] == max) count++;
        
        int[] result = new int[count];
        int idx = 0;
        for (int i=0; i<3; i++) {
            if (correct[i] == max) {
                result[idx] = i+1;
                idx++;  
            }
        }
        
        return result;
    }
}