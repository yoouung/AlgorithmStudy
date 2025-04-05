class Solution {
    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        String[] str = s.split(" ");
        
        for (String n: str) {
            int num = Integer.parseInt(n);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        
        return (String) (min + " " + max);
    }
}