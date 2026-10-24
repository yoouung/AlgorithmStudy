import java.util.*;

class Solution {
    /*
    - 구하는 것: begin -> target 최소 횟수
    - 조건
    1. words에 target 없으면 return 0
    2. 한번에 한 알파벳만 달라야 함
    3. 가능한 경우가 많아도 최소 단계 수를 반환해야 함
    4. *배열 인덱스 순서대로 탐색할 필요는 없음
    - 알고리즘 후보: dfs, 백트래킹..? ====> BFS (이동횟수가 동일한 조건에서 최단 거리 구하기)
    */
    
    class Node {
        String word;
        int count;
        
        Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    
    public int solution(String begin, String target, String[] words) {    
        boolean[] visited = new boolean[words.length];
        
        return bfs(begin, target, visited, words);
    }
    
    int bfs(String begin, String target, boolean[] visited, String[] words) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(begin, 0));
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            String cs = current.word;
            int cc = current.count;
            
            if (cs.equals(target)) {
                return cc;
            }

            for (int i=0; i<words.length; i++) {
                String ns = words[i];
                if (!visited[i] && canChange(cs, ns)) {
                    visited[i] = true;
                    queue.offer(new Node(ns, cc + 1));
                }
            }
        }
        
        return 0;
    }


    /* 처음 DFS, 백트래킹 코드
    
        int result = Integer.MAX_VALUE;

        public int solution(String begin, String target, String[] words) {    
            boolean[] visited = new boolean[words.length];

            backtracking(begin, target, words, visited, 0);

            if (result >= words.length) {
                return result == Integer.MAX_VALUE ? 0 : result;
            }

            return result;
        }

        void backtracking(String begin, String target, String[] words, boolean[] visited, int count) {
            if (count >= result) {
                return ;
            }

            if (begin.equals(target)) {
                result = Math.min(result, count);
                return;
            }

            for (int i=0; i < words.length; i++) {
                String next = words[i];
                if (!visited[i] && canChange(begin, next)) {
                    visited[i] = true;
                    backtracking(next, target, words, visited, count + 1);
                    visited[i] = false;
                }
            }

            return;


        }
    
    */
    
    boolean canChange(String a, String b) {
        int diffCount = 0;
        
        for (int i=0; i<a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diffCount++;
            }
            if (diffCount > 1) {
                return false;
            }
        }
        
        return diffCount == 1;
    }
}