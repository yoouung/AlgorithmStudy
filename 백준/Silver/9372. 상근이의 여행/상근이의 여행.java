import java.util.*;
import java.io.*;

public class Main {
  /*
  최단거리 = dfs, 백트레킹?
  항상 연결 그래프를 이룬다 -> 1. 순환 가능 2. 순환 불가능
  => 둘 다 n-1개의 비행기로 여행 가능
  */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            for (int m=0; m<M; m++) {
                st = new StringTokenizer(br.readLine());
            }
            
            System.out.println(N-1);
        }
    }
}