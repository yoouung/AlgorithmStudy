import java.util.*;

class Solution {
    /*
    boundary 영역 추가 -> 외곽과 닿아있는 부분을 '-'로 판별
    */
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n, m;
    static char[][] arr;
    static boolean[][] boundary;
    
    public int solution(String[] storage, String[] requests) {
        n = storage.length + 2; // 상하 + 2
        m = storage[0].length() + 2; // 좌우 +2
        arr = new char[n][m];
        
        for (int i=0; i<n; i++) { // boundary 설정
            Arrays.fill(arr[i], '-');
        }
        
         for (int i=1; i<n-1; i++) {
             for (int j=1; j<m-1; j++) {
                 arr[i][j] = storage[i-1].charAt(j-1);
             }
        } 
        
        for (String req: requests) {
            if (req.length() == 2) { // 크레인
                for (int i=0; i<n; i++) {
                    for (int j=0; j<m; j++) {
                        if (arr[i][j] == req.charAt(0)) {
                            arr[i][j] = '-';
                        }
                    }
                }
            } else { // 지게차
                boundary = new boolean[n][m];    
                bfs();
                
                List<int[]> removeList = new ArrayList<>();
                
                 for (int i=1; i<n-1; i++) {
                     for (int j=1; j<m-1; j++) {
                         if (arr[i][j] == req.charAt(0)) {
                             // 상하좌우 하나라도 '-'이면 제거 가능
                             for (int k=0; k<4; k++) {
                                 int nx = i + dx[k];
                                 int ny = j + dy[k];
                                 if (arr[nx][ny] == '-' && boundary[nx][ny]) {
                                     removeList.add(new int[]{i, j});
                                     break;
                                 }
                             }
                         }
                     }
                 }
                
                for (int[] r : removeList) {
                    arr[r[0]][r[1]] = '-';
                } 
            }   
        }
        
        int count = 0;
         for (int i=1; i<n-1; i++) {
             for (int j=1; j<m-1; j++) {
                 if (arr[i][j] != '-') {
                     count++;
                 }
             }
        } 
        return count;
    }
    
    static void bfs() { // '-'와 연결된 부분 탐색
        Queue<int[]> queue = new LinkedList<>(); 
        queue.offer(new int[]{0, 0});
        boundary[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            
            for (int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == '-' && !boundary[nx][ny]) {
                    boundary[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
}