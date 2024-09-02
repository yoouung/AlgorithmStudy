import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    char[] king = st.nextToken().toCharArray();
    char[] stone = st.nextToken().toCharArray();
    int count = Integer.parseInt(st.nextToken());

    for (int i = 0; i < count; i++) {
      String direction = br.readLine();
      char[] nextK = move(direction, king);
      if (isInRange(nextK)) {
        if (nextK[0] == stone[0] && nextK[1] == stone[1]) {
          char[] nextS = move(direction, stone);
          if (isInRange(nextS)) {
            king = nextK;
            stone = nextS;
          }
        } else {
          king = nextK;
        }
      }
    }

    sb.append(king).append("\n").append(stone);
    System.out.println(sb.toString());
  }

  static boolean isInRange(char[] next) {
    if (next[0] >= 'A' && next[0] <= 'H' && next[1] >= '1' && next[1] <= '8') {
      return true;
    } else {
      return false;
    }
  }

  static char[] move(String direction, char[] target) {
    char[] current = target.clone();

    switch (direction) {
      case "R":
        current[0]++;
        break;
      case "L":
        current[0]--;
        break;
      case "B":
        current[1]--;
        break;
      case "T":
        current[1]++;
        break;
      case "RT":
        current[0]++;
        current[1]++;
        break;
      case "LT":
        current[0]--;
        current[1]++;
        break;
      case "RB":
        current[0]++;
        current[1]--;
        break;
      case "LB":
        current[0]--;
        current[1]--;
        break;
    }

    return current;
  }
}
