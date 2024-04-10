package 프로그래머스;
import java.util.*;

public class 문자열반복 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            sb.append(str);
        }
        System.out.println(sb.toString());
    }
}

