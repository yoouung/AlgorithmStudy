package 백준.Silver;

import java.util.*;

public class B1874_스택 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        int num = 1;
        boolean result = true;

        for (int i = 0; i < N; i++) {
            if (numbers[i] >= num) {
                while (numbers[i] >= num) {
                    sb.append("+\n");
                    stack.push(num);
                    num++;
                }
                sb.append("-\n");
                stack.pop();
            } else {
                if (numbers[i] < stack.peek()) {
                    System.out.println("NO");
                    sb.append("-\n");
                    stack.pop();
                    result = false;
                    break;
                    // 2 3 1 5      2/1
                } else {
                    sb.append("-\n");
                    stack.pop();
                }
            }
        }
        if (result) {
            System.out.println(sb.toString());
        }
    }
}
