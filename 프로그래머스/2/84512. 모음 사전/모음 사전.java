class Solution {
    static int count = 0;
    char[] chars = {'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        return dfs("", word);
    }
    
    int dfs(String current, String target) {
        if (!current.isEmpty()) { // 빈값이면 넘어감
            count++;   
            
            if (current.equals(target)) {
                return count;
            }
            if (current.length() == 5) {
                return -1;
            }
        }
        
        for (int i=0; i<chars.length; i++) { // => for (char c: chars) {}
            int result = dfs(current + chars[i], target);  // => dfs(current+c, target)
            if (result != -1) {
                return result;
            }
        }
        return -1;
    }
}