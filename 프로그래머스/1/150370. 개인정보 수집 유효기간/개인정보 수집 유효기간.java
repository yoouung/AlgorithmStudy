import java.util.*;

/*
* - split("\\."): .은 정규식에서 모든 문자를 의미하므로 .이 아닌 \\.으로 표기
*/

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> expires = new ArrayList<>();
        String[] todayDate = today.split("\\.");
        HashMap<String, Integer> termRule = new HashMap<>();
        for (String term: terms) {
            termRule.put(term.split(" ")[0], Integer.parseInt(term.split(" ")[1]));
        }
        
        for (int i=0; i<privacies.length; i++) {
            String date = privacies[i].split(" ")[0];
            String term = privacies[i].split(" ")[1];
            String expirationDate = getExpirationDate(date, termRule.get(term));
            if (shouldExpire(expirationDate, today)) {
                expires.add(i+1);
            }
        }
        
        int[] answer = new int[expires.size()];
        for (int i=0; i<expires.size(); i++) {
            answer[i] = expires.get(i);
        }
        return answer;
    }
    
    static String getExpirationDate(String date, int due) {
        int year = Integer.parseInt(date.split("\\.")[0]);
        int month = Integer.parseInt(date.split("\\.")[1]);
        int day = Integer.parseInt(date.split("\\.")[2]);
        
        month += due;  
        
        year += (month - 1) / 12;
        month = (month - 1) % 12 + 1;
        
        day -= 1;
        if (day == 0) {
            month -= 1;
            if (month == 0) {
                year -= 1;
                month = 12;
            }
            day = 28;
        }
        
        return String.format("%d.%02d.%02d", year, month, day);
    }
    
    static boolean shouldExpire(String expirate, String today) {
        int yearE = Integer.parseInt(expirate.split("\\.")[0]);
        int monthE = Integer.parseInt(expirate.split("\\.")[1]);
        int dayE = Integer.parseInt(expirate.split("\\.")[2]);
        
        int yearT = Integer.parseInt(today.split("\\.")[0]);
        int monthT = Integer.parseInt(today.split("\\.")[1]);
        int dayT = Integer.parseInt(today.split("\\.")[2]);
        
        if (yearE < yearT) {
            return true;
        } else if (yearE == yearT && monthE < monthT) {
            return true;
        } else if (yearE == yearT && monthE == monthT && dayE < dayT) {
            return true;
        }
        return false;
    }
}