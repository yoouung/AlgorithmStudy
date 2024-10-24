class Solution {
    public int solution(String t, String p) {
        int count = 0;
        int len = p.length();
        long parsedP = Long.parseLong(p);
        
        for (int i = 0; i <= t.length() - len; i++) {
            long slicedT = Long.parseLong(t.substring(i, i+len));
            if (slicedT <= parsedP) count++;
        }
        
        return count;
    }
}