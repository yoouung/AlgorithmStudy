package 백준.Bronze;
import java.util.Scanner;

public class B11720_숫자의합 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        String sNum = scanner.next();
        scanner.close();

        char[] num_list = sNum.toCharArray();
        int sum = 0;

        for (int i = 0; i < x; i++) {
            sum += num_list[i] - '0'; // char to int
        }

        System.out.println(sum);
    }
}
