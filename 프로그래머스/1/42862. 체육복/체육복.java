import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int result = n;
        int[] haveClothes = new int[n+1];
        Arrays.fill(haveClothes, 1);
        
        for (int i: reserve) {
            haveClothes[i]++;
        }
        for (int i: lost) {
            if (haveClothes[i] != 2) { // 여벌 안가져온 애가 도난당한 경우만 result 감소
                result--;
            }
            haveClothes[i]--;
        }
        
        for (int i=1; i<=n; i++) {
            if (haveClothes[i] == 2) {
                // 앞 학생에게 빌려줄 수 있는지 확인
                if (haveClothes[i - 1] == 0) {
                    haveClothes[i]--;
                    haveClothes[i - 1]++;
                    result++;
                } 
                // 뒷 학생에게 빌려줄 수 있는지 확인
                else if (i < n && haveClothes[i + 1] == 0) {
                    haveClothes[i]--;
                    haveClothes[i + 1]++;
                    result++;
                }
            }
        }
        
        return result;
    }
}