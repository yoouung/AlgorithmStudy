import java.util.*;

class Solution {
    /*
    - 구하는 것: 나가고 들어오고의 로그
    - 조건
    1. 닉네임 중복 허용 -> 닉네임이 같아도 유저id로 구분해야 함
    2. 최종 결과만 출력 - 과정 필요없음
    3. 유저 아이디, 닉네임 대소문자 구별
    - 알고리즘 후보: 구현, 브루트포스?
    - 내 생각: 배열 길이가 길지 않으므로 단순 반복도 괜찮을 것 같음
    */
    
    public String[] solution(String[] record) {
        
        Map<String, String> nicknames = new HashMap<>(); // uid, nickname
        for (String message: record) {
            String[] parts = message.split(" "); // split 한번만
            String action = parts[0];
            String uid = parts[1];
            
            if (action.equals("Leave")) {
                continue;
            }
            
            String nickname = parts[2];
            nicknames.put(uid, nickname); // map은 동일한 key 존재하면 알아서 value 덮어씀
            
        }
        

        ArrayList<String> logs = new ArrayList<>();
        
        for (int i=0; i<record.length; i++) {
            String message = record[i];
            String action = message.split(" ")[0];
            String uid = message.split(" ")[1];
            
            if (action.equals("Enter")) {
                logs.add(nicknames.get(uid) + "님이 들어왔습니다.");
            } else if (action.equals("Leave")) {
                logs.add(nicknames.get(uid) + "님이 나갔습니다.");
            }
        }
        
        return logs.toArray(new String[0]);
    }
}