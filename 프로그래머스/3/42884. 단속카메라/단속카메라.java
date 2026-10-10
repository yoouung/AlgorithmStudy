import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 진출 지점이 빠른 순서대로 정렬
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        
        // 아직 단속되지 않은 차량이 나오면 해당 차량의 진출 지점에 카메라 설치
        // 이미 설치된 카메라를 지나는 차량은 건너뜀
        int cctv = routes[0][1]; // 첫번째 cctv
        int count = 1; // 첫번째 cctv 포함
        
        for (int i=1; i<routes.length; i++) {
            if (routes[i][0] > cctv) {
                cctv = routes[i][1];
                count++;
            }
        }
        return count;
    }
}