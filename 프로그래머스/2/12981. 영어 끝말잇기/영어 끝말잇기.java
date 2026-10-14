import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        // 원래 내 코드: Map<Character, ArrayList<String>> map = new HashMap<>();
        Set<String> used = new HashSet<>();
        
        for (int i=0; i<words.length; i++) {  
            String word = words[i];
            int who = i % n + 1;
            int turn = i / n + 1;
            
            if (i>0) {
                String prev = words[i-1];
                if (prev.charAt(prev.length()-1) != (word.charAt(0))) {
                    return new int[]{who, turn};
                }
            }
            
            if (!used.add(word)) {
                return new int[]{who, turn};
            }
            
            // map.computeIfAbsent
            // Map에 해당 키가 없거나 연결된 값이 null이면, 새로운 값을 생성해 저장한 뒤 반환
            // 예를 들어 w = 'a'라면 실제로 람다식의 k에는 'a'가 전달
            // List<String> list = map.computeIfAbsent(w, k -> new ArrayList<>());

        }

        return new int[]{0, 0};
    }
}