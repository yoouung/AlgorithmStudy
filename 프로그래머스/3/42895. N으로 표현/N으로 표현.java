import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> results = new ArrayList<>();
        for (int i=0; i<=8; i++) {
            results.add(new HashSet<>());
        }
        
        results.get(1).add(N); // 1개 쓰면 자기 자신뿐
        
        for (int i=2; i< 9; i++) { // 사용 횟수 최대 8회
            Set<Integer> currentSet = results.get(i);
            
            for (int j = 1; j < i; j++) {
                Set<Integer> first = results.get(j);
                Set<Integer> second = results.get(i-j);
                
                for (int fn: first) {
                    for (int sn: second) {
                        currentSet.add(fn + sn);
                        currentSet.add(fn - sn);
                        currentSet.add(fn * sn);
                        
                        if (fn != 0 && sn != 0) {
                            currentSet.add(fn / sn);
                        }
                    }
                }
            }
            
            currentSet.add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }
        
        
        for (Set<Integer> find: results) {
            if (find.contains(number)) {
                return results.indexOf(find);
            }
        }
        
        return -1;
    }
}