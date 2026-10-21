import java.util.*;

class Solution {
    /*
    - 구하는 것: 자동차별 주차요금
    - 조건
    1. 출차 정보 없으면 23:59 출차
    2. 초과한 시간이 단위시간으로 나누어 떨어지지 않으면 올림 (=몫+1)
    3. 차량번호 작은 순서대로 배열return
    - 알고리즘 후보: 구현
    */
    public int[] solution(int[] fees, String[] records) {
        int defaultTime = fees[0];
        int defaultCost = fees[1];
        int unitTime = fees[2];
        int unitCost = fees[3];
        
        // Key를 기준으로 자동 오름차순 정렬되는 Map
        // 차량번호 → [입차 시각, 누적 주차 시간]
        TreeMap<String, int[]> map = new TreeMap<>();
        
        for (String record: records) {
            String[] infos = record.split(" ");
            String time = infos[0];
            String num = infos[1];
            String cat = infos[2];
            
            String[] clock = time.split(":");
            int minutes = Integer.parseInt(clock[0])*60 + Integer.parseInt(clock[1]);
            
            if (cat.equals("IN")) {
                if (map.containsKey(num)) {
                    map.get(num)[0] = minutes;
                } else {
                    map.put(num, new int[]{minutes, 0});
                }
            } else if (cat.equals("OUT")) {
                int[] info = map.get(num);
                info[1] += minutes - info[0];
                info[0] = -1; // 출차 상태 표시
            }
        }
        
        int[] answer = new int[map.size()];
        int idx = 0;
        for (int[] info : map.values()) {
            int totalTime = info[1];

            // 출차하지 않은 차량
            if (info[0] != -1) {
                totalTime += 1439 - info[0];
            }             

            // 추가 주차 시간
            int extra = Math.max(0, totalTime - defaultTime);

            // 추가 요금 단위 (올림)
            int units = (extra + unitTime - 1) / unitTime;

            // 최종 요금
            answer[idx++] = defaultCost + units * unitCost;
        }
        
        return answer;
    }
}