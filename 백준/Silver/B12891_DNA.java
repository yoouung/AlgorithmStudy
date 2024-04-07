package solving.BOJ;

import java.util.*;
import java.io.*;

public class B12891_DNA {
    static int[] myCount;
    static int[] check;
    static int checkSecret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken()); // original length
        int P = Integer.parseInt(st.nextToken()); // password length
        check = new int[4]; // A, C, G, T 최소 개수
        char[] current = new char[S]; // 내가 검토하고 있는 부분 문자열
        myCount = new int[4]; // 내가 검토하고 있는 부분 문자열의 A,C,G,T 개수
        checkSecret = 0; // 내가 검토하고 있는 부분 문자열이 만족하는 char 개수
        int result = 0; // answer(가능한 비밀번호 개수)

        current = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            check[i] = Integer.parseInt(st.nextToken());
            if (check[i] == 0) { // 최소 개수가 0이라면 배열 안에 있는지 체크 안해도 됨
                checkSecret++;
            }
        }

        /*  부분 문자열의 원소 하나씩 검토하면서
         *  current 배열에서 각각이 해당하는 문자의 개수를 1씩 더함
        */
        for (int i = 0; i < P; i++) {
            Add(current[i]);
        }

        if (checkSecret == 4)
            result++;
        
        /*  슬라이딩 윈도우
            - 부분 문자열의 전체를 다시 검토하지 않고 새로 추가된 부분만 검토
        */
        for (int i = P; i < S; i++) {
            int j = i - P; // 부분 문자열 start point
            Add(current[i]);
            Remove(current[j]);

            if (checkSecret == 4)
                result++;
        }

        System.out.println(result);
        br.close();
    }

    private static void Add(char c) {
        switch (c) {
            case 'A':
                myCount[0]++;
                if (myCount[0] == check[0])
                    checkSecret++;
                break;
            case 'C':
                myCount[1]++;
                if (myCount[1] == check[1])
                    checkSecret++;
                break;
            case 'G':
                myCount[2]++;
                if (myCount[2] == check[2])
                    checkSecret++;
                break;
            case 'T':
                myCount[3]++;
                if (myCount[3] == check[3])
                    checkSecret++;
                break;
        }
    }

    public static void Remove(char c) {
        switch (c) {
            case 'A':
                if (myCount[0] == check[0])
                    checkSecret--;
                myCount[0]--;
                break;
            case 'C':
                if (myCount[1] == check[1])
                    checkSecret--;
                myCount[1]--;
                break;
            case 'G':
                if (myCount[2] == check[2])
                    checkSecret--;
                myCount[2]--;
                break;
            case 'T':
                if (myCount[3] == check[3])
                    checkSecret--;
                myCount[3]--;
                break;
        }
    }
}
