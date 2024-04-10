package 백준.Silver;

import java.util.*;

public class B2018_수들의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int start = 1;
        int end = 1;
        int count = 1;
        int sum = 1;

        while (end != N) {
            if (sum == N) {
                count ++;
                end ++;
                sum += end;
            } else if (sum > N) {
                sum -= start;
                start ++;
            } else if (sum < N) {
                end ++;
                sum += end;
            }
        }

        System.out.println(count);
    }
}