import java.io.*;
import java.util.*;

public class Main {
    /*
     * 연결 요소의 개수 = DFS 횟수
     */

    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1]; // 1~n 인덱스 쓰기 위해 n+1로 초기화
        graph = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) { // 각 노드별 리스트 초기화
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            graph[first].add(second);
            graph[second].add(first);
        }

        int count = 0; // 연결요소 개수      
        for (int i = 1; i < N+1; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }

        System.out.println(count);
    }
    
    private static void dfs(int node) {
        if (visited[node]) { // 이미 방문한 노드라면 패스
            return;
        }

        visited[node] = true; // 방문 처리

        for (int i : graph[node]) { // node에 연결된 노드들을 모두 탐색
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}