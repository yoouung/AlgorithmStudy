package solving.SWExpert;

import java.util.*;

public class no2_AI {
    static int[] check = new int[3];
    static int N, total, maxTotal;
    static boolean[] visited;
    static int answer;
    static int[][] heroes;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            heroes = new int[N][4];
            visited = new boolean[N];
            total = 0;

            for (int i = 0; i < N; i++) {
                heroes[i][0] = sc.nextInt();
                heroes[i][1] = sc.nextInt();
                heroes[i][2] = sc.nextInt();
                heroes[i][3] = Math.max(heroes[i][0], Math.max(heroes[i][1], heroes[i][2]));

                total += heroes[i][0] + heroes[i][1] + heroes[i][2];
                maxTotal += heroes[i][3];
            }

            if (N < 3) {
                System.out.println("#" + test_case + " -1");
                continue;
            }

            answer = Integer.MIN_VALUE;

            // 모든 요원에 대해 시작
            for (int i = 0; i < N; i++) {
                visited[i] = true;
                check(new ArrayList<Integer>(Arrays.asList(i)), heroes[i][0]);
                visited[i] = false;
            }
            
            int totalLoss = total - answer;
            System.out.println("#" + test_case + " " + totalLoss);
        }
    }
    
    static void check(ArrayList<Integer> heroesList, int currentPower) {
        if (heroesList.size() == 3) {
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    currentPower += heroes[i][3];
                }
            }
            answer = Math.max(answer, currentPower);
            return;
        }

        int possibleMax = currentPower + maxTotal;
        for (int heroIndex : heroesList) {
            possibleMax -= heroes[heroIndex][3];
            if (possibleMax <= answer)
                return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            heroesList.add(i);
            check(heroesList, currentPower + heroes[i][heroesList.size() - 1]);
            heroesList.remove(heroesList.size() - 1);
            visited[i] = false;
        }
    }
}