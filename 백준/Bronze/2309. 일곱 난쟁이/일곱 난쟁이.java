import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] people = new int[9];
    List<Integer> answer = new ArrayList<>();

    for (int i = 0; i < 9; i++) {
      people[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(people);

    for (int i = 0; i < 8; i++) {
      for (int k = i + 1; k < 9; k++) {

        int sum = 0;
        answer = new ArrayList<>();

        for (int m = 0; m < 9; m++) {
          if (m != i && m != k) {
            sum += people[m];
            answer.add(people[m]);
          }
        }
          
        if (sum == 100 && answer.size() == 7) {
          for (int ans: answer) {
            System.out.println(ans);
          }
            
          System.exit(0);
        }
      }
    }

    
  }
}
