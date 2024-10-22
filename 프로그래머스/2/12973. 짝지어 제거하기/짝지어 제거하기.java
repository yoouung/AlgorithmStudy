import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        
        for (int i=1; i<s.length(); i++) {
            char currentChar = s.charAt(i);
            
            if (!stack.isEmpty() && stack.peek() == currentChar) {
                stack.pop();
            } else {
                stack.push(currentChar);
            }
        }
        
                
        if (stack.isEmpty()) {
            return 1;
        } 
        return 0;
    }
}