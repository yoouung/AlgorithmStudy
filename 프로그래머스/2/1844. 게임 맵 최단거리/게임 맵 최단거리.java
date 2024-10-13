import java.util.*;

class Solution {
    static int n, m;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int count = 0;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        
        return bfs(maps);
    }
    
    static int bfs(int[][] maps) {
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            if (x == n - 1 && y == m - 1) {
                return maps[x][y];
            }
            
            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny] && maps[nx][ny] == 1) {
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        maps[nx][ny] = maps[x][y] + 1;
                    }
                }
            }
        }
        
        return -1;
        
        
    }
}