import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String s: operations) {
            String mode = s.split(" ")[0];
            int num = Integer.parseInt(s.split(" ")[1]);
            
            if (mode.equals("I")) {
                minPQ.offer(num);
                maxPQ.offer(num);
            } else { // "D"
                if (minPQ.isEmpty() || maxPQ.isEmpty()) continue;
                
                if (num == 1) {
                    minPQ.remove(maxPQ.poll());
                } else {
                    maxPQ.remove(minPQ.poll());
                }
            }
        }
        
        if (minPQ.isEmpty()) {
            return new int[] {0, 0};
        } else {
            int max = maxPQ.poll();
            int min = minPQ.poll();
            return new int[] {max, min};
        }
        
    }
}