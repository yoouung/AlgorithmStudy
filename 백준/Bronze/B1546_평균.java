package 백준.Bronze;
import java.util.*;

public class B1546_평균 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        long sum = 0;
        long max = 0;
        
        for (int i = 0; i < x; i++) {
            int score = scanner.nextInt();
            if (score > max) {
                max = score;
            }
            sum += score;
        }

        System.out.println(sum * 100.0 / max  / x);
        
    }
}