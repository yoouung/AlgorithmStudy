import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int n : scoville) {
            pq.add(n);     
        }
        
        while(pq.peek() < K) { // 가장 작은 수
            if (pq.size() == 1) {
                return -1;
            }
            pq.add(pq.poll() + pq.poll() * 2);
            count++;
        }
        
        return count;
    }
    
}