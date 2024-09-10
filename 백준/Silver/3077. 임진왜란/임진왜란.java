import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    Map<String, Integer> map = new HashMap<>();
    
    for (int i = 0; i < N; i++) {
      map.put(st.nextToken(), i);
    }
    String[] my = br.readLine().split(" ");

    int count = 0;
    for (int i = 0; i < N - 1; i++) {
      for (int j = i + 1; j < N; j++) {
        if (map.get(my[i]) < map.get(my[j])) {
          count++;
        }
      }
    }

    System.out.println(count + "/" + N*(N-1)/2);
  } 
}
