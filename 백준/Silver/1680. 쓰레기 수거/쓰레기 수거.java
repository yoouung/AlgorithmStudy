import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    
    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int W = Integer.parseInt(st.nextToken());
      int N = Integer.parseInt(st.nextToken());
      int[][] points = new int[N+1][2];
      int distance = 0;
      int currentWeight = 0;
      
      for (int j = 1; j <= N; j++) {
        st = new StringTokenizer(br.readLine());
        points[j][0] = Integer.parseInt(st.nextToken());
        points[j][1] = Integer.parseInt(st.nextToken());

        distance += points[j][0] - points[j - 1][0];
        
        if (currentWeight + points[j][1] < W) {
          currentWeight += points[j][1];
        } else if (currentWeight + points[j][1] == W) {
          if (j == N) { // 마지막 쓰레기장이면 종료
            continue;
          }
          distance += points[j][0] * 2; // 비우러 가기
          currentWeight = 0;
        } else {
          distance += points[j][0] * 2; // 왔다갔다
          currentWeight = points[j][1];
        }
      }

      distance += points[N][0]; // 마지막에 쓰레기장으로 돌아가는 거리
      System.out.println(distance);
    }
  }
}
