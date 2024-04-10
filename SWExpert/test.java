package SWExpert;

import java.io.*;
import java.util.*;

public class test {
    static boolean[] check = new boolean[3]; // 능력치 공유 가능한지 확인
    static int n;
    static boolean[] visited;
    static int total, maxTotal;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // number of test case

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt(); // 요원 수
            int[][] heroes = new int[N][4];

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
            for (int i = 0; i < n; i++) {
                int sum = heroes[i][0] + heroes[i][1] + heroes[i][2];
                check(heroes, 0, new int[]{heroes[i][0]}, heroes[i][3], sum);
            }    

            int totalLoss = total - answer;
            System.out.println("#" + test_case + " " + totalLoss);
        }
    }

    static void check(int[][] heroes, int currentIndex, int[] sharedPowers,
            int maxDestroyedPowers, int totalPowers) {
        if (sharedPowers.length == 3) {
            int totalDestroyedPowers = totalPowers - sharedPowers[0] - sharedPowers[1] - sharedPowers[2];
            answer = Math.min(answer, totalDestroyedPowers);
            return;
        }

        if (currentIndex == heroes.length) {
            return;
        }

        for (int i = 0; i < 3; i++) {
            int[] nextSharedPowers = { sharedPowers[0], sharedPowers[1], sharedPowers[2] };
            nextSharedPowers[sharedPowers.length] = heroes[currentIndex][i];
            check(heroes, currentIndex + 1, nextSharedPowers, heroes[currentIndex][3],
                    totalPowers);
        }
    }
}