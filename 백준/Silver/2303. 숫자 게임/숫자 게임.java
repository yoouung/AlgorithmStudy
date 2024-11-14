import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] max = new int[N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int[] nums = new int[5];

      for (int j = 0; j < 5; j++) {
        nums[j] = Integer.parseInt(st.nextToken());
      }
      for (int j = 0; j < 3; j++) {
        for (int k = j + 1; k < 4; k++) {
          for (int l = k + 1; l < 5; l++) {
            String current = String.valueOf(nums[j] + nums[k] + nums[l]);
            max[i] = Math.max(max[i], current.charAt(current.length() - 1) - '0');
          }
        }
      }
    }

    int maxIndex = 0;
    int maxValue = 0;

    for (int i = 0; i < N; i++) {
      if (max[i] >= maxValue) {
        maxValue = max[i];
        maxIndex = i + 1;
      }
    }

    System.out.println(maxIndex);
  }
}
