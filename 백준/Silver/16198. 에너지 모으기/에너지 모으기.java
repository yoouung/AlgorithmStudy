import java.util.*;
import java.io.*;

public class Main {
  /*
  백트레킹
  - N < 10 이므로 브루트포스 / 백트래킹 가능
  -

   */

    static int N;
    static int totalEnergy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ArrayList<Integer> marbles = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            marbles.add(Integer.parseInt(st.nextToken()));
        }

        dfs(marbles, 0);
        System.out.println(totalEnergy);

    }

    static void dfs(ArrayList<Integer> currentArr, int sum) {
        int len = currentArr.size();
        if (len == 2) {
            totalEnergy = Math.max(totalEnergy, sum);
            return;
        }

        for (int i=1; i<len-1; i++) { // 양끝 안됨
            int energy = currentArr.get(i-1) * currentArr.get(i+1);
            int remove = currentArr.remove(i);
            dfs(currentArr, sum + energy);
            currentArr.add(i, remove); // 백트레킹
        }
    }
}
