import java.util.*;

class Solution {
    static boolean[] visited;
    static int count = 0;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                dfs(n, computers, i);
                count++;
            }
        }
        return count;
    }
    
    static void dfs(int n, int[][] computers, int index) {
        Stack<Integer> stack = new Stack<>();
        stack.push(index);
        visited[index] = true;
        
        while (!stack.isEmpty()) {
            int current = stack.pop();
            
            for (int i=0; i< n; i++) {
                if (!visited[i] && computers[current][i] == 1) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
    }
}

// 재귀쓰는 dfs

// class Solution {
//     static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
//     static boolean[] visited;
//     static int count = 0;

//     public int solution(int n, int[][] computers) {
//         visited = new boolean[n];
        
//         // 인접 리스트 초기화
//         for (int i = 0; i < n; i++) {
//             graph.add(new ArrayList<Integer>());
//         }
        
//         // 인접 행렬을 인접 리스트로 변환
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (computers[i][j] == 1 && i != j) {
//                     graph.get(i).add(j); // 컴퓨터 i와 j가 연결되어 있음을 의미
//                 }
//             }
//         }

//         // 각 노드를 DFS로 탐색하여 네트워크 개수 계산
//         for (int i = 0; i < n; i++) {
//             if (!visited[i]) {
//                 dfs(i);
//                 count++;
//             }
//         }
//         return count;
//     }

//     // 재귀적으로 DFS를 구현
//     static void dfs(int node) {
//         visited[node] = true;  // 현재 노드 방문 처리

//         // 현재 노드와 연결된 다른 노드들을 방문
//         for (int neighbor : graph.get(node)) {
//             if (!visited[neighbor]) {
//                 dfs(neighbor);  // 재귀 호출로 연결된 노드를 방문
//             }
//         }
//     }
// }
