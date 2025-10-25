class Solution {        
    private StringBuilder sb = new StringBuilder();
    private int[] alpha = new int[27];
    
    public String solution(String[] survey, int[] choices) {
        int len = survey.length;
        
        for (int i=0; i<len; i++) {
            char[] currentSurvey = survey[i].toCharArray();
            int currentChoice = choices[i];
            
            if (currentChoice < 4) {
                alpha[currentSurvey[0] - 'A'] += Math.abs(currentChoice - 4);
            } else if (currentChoice > 4) {
                alpha[currentSurvey[1] - 'A'] += currentChoice - 4;
            }
        }
        
        makeResult('R', 'T');
        makeResult('C', 'F');
        makeResult('J', 'M');
        makeResult('A', 'N');
        
        return sb.toString();
    }
    
    private void makeResult(char a, char b) {
        if (alpha[a - 'A'] > alpha[b - 'A']) {
            sb.append(a);
        } else if (alpha[a - 'A'] < alpha[b - 'A']) {
            sb.append(b);
        } else {
            sb.append(a);
        }
    }
}