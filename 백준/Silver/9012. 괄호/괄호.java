
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringBuffer sb = new StringBuffer();

    for (int i = 0; i < N; i++) {
      String st = br.readLine();
      
      Stack<Character> stack = new Stack<>();
      boolean isVPS = true;

      for (int j=0; j<st.length(); j++) {
        char ch = st.charAt(j);

        if (ch == '(') {
          stack.push(ch);
        } else if (ch == ')') {
          if (stack.isEmpty()) {
            isVPS = false;
            break;
          } else {
            stack.pop();
          }
        }
      }

      if (!stack.isEmpty()) {
        isVPS = false;
      }

      if (stack.isEmpty() && isVPS) {
        sb.append("YES");
      } else {
        sb.append("NO");
      }
      sb.append("\n");
    }

    System.out.println(sb.toString());
  }
}
