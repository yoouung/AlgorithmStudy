import java.util.*;

class Solution {
    /*
    구하는 것: 총 실행 시간
    - Queue: .offer, .poll, .peek, .remove
    - LRU: cache hit여도 해당 도시가 가장 최근에 사용된 데이터가 되도록 순서를 변경
    - cacheSize = 0일 경우 cache.poll()이 불가능함
    */
    public int solution(int cacheSize, String[] cities) {
        int time = 0;
        Queue<String> cache = new LinkedList<>();
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        for (String city: cities) {
            String lowercity = city.toLowerCase(); // 대소문자 구분 삭제
            if (cache.contains(lowercity)) {
                cache.remove(lowercity);
                cache.offer(lowercity);
                time += 1;
                continue;
            }
            
            if (cache.size() == cacheSize) {
                cache.poll();
            }
            cache.offer(lowercity);
            time += 5;
        }
        
        return time;
    }
}