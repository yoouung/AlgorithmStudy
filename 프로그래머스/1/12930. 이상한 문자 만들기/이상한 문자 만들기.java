import java.util.*;

class Solution {
    // char은 기본자료형이기 때문에,
    // array[i].toUpperCase() 처럼 메소드 호출이 안됨
    // -> Character.toUpperCase(array[i])와 같이 Character 클래스의 정적 메소드를 사용해야 한다.
    
    // " " 은 String, ' '은 char
    
    public String solution(String s) {
        String result = "";
        String[] split = s.split("");
        int count = 0;
        
        for (String ss: split) {
            count = ss.equals(" ") ? 0 : count + 1;
            result += count % 2 == 0 ? ss.toLowerCase() : ss.toUpperCase();
        }
        
        return result;
    }
    
//     // 내 풀이
//     public String solution(String s) {
//         StringBuilder sb = new StringBuilder();
        
//         int tempIndex = 0;
//         for (int i=0; i < s.length(); i++) {
//             char current = s.charAt(i);
            
//             if (current == ' ') {
//                 tempIndex = 0;
//                 sb.append(current);
//                 continue;
//             }
            
//             if (tempIndex % 2 == 0) {
//                 sb.append(Character.toUpperCase(current)); 
//             } else {
//                 sb.append(Character.toLowerCase(current));
//             }
//             tempIndex++;
//         }
        
//         return sb.toString();
//     }
}