import java.util.*;

class Solution {
    /* 크루스칼 알고리즘 - 유니온파인드
    / - 그래프의 최소 비용 연결 구조를 구성 (MST)
    / - 여러 노드가 있을 때, 두 노드가 같은 그래프에 속해있는지 알 수 있음.
    */
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        // 정렬: 비용이 낮은 다리부터
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
        
        // 초기화
        parent = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
        }
        
        int total = 0; // 총 비용
        int count = 0; // 다리 개수
        // 순회
        for (int[] cost: costs) {
            int x = cost[0];
            int y = cost[1];
            int c = cost[2];
            
            if (union(x, y)) { // 서로 다른 그룹일 때만 다리 건설
                total += c;
                count++;
            }
            
            if (count == n -1) {
                break;
            }
        }
        
        return total;
    }
    
    
    boolean union(int x, int y) { // 부모 노드 업데이트
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
            return true;
        }
        return false;
    }
    
    int find(int x) { // 경로 압축
        if (parent[x] == x) return x;
        return find(parent[x]);
    }
}