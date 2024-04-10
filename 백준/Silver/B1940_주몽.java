package 백준.Silver;

import java.io.*;
import java.util.*;

public class B1940_주몽 {
    // 재료는 한 번 쓰면 끝
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 오름차순 정렬 +) 내림차순: Arrays.sort(arr, Collections.reverseOrder());

        int start = 0;
        int end = N-1;
        int count = 0;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum < M)
                start++;
            else if (sum > M)
                end--;
            else if (sum == M) {
                count++;
                start++;
                end--;
            }
        }
        
        System.out.println(count);
    }
}
