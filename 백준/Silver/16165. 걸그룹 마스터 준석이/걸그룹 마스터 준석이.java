import java.util.*;
import java.io.*;

public class Main {
  /*
  시간제한 2초, N,M 최대 100 -> 브루트 상관없을듯
   */


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    HashMap<String, String[]> members = new HashMap<>();

    for (int i=0; i<N; i++) {
        String groupName = br.readLine();
        int C = Integer.parseInt(br.readLine());
        members.put(groupName, new String[C]);
        for (int j=0; j<C; j++) {
            members.get(groupName)[j] = br.readLine();
        }
    }

    StringBuilder sb = new StringBuilder();
    for (int i=0; i<M; i++) {
        String target = br.readLine();
        int quizType = Integer.parseInt(br.readLine());
        if (quizType == 0) {
            Arrays.sort(members.get(target));
            for (String s : members.get(target)) {
                sb.append(s).append('\n');
            }
        } else {
            for (Map.Entry<String, String[]> group: members.entrySet()){
                for (String member: group.getValue()) {
                    if (member.equals(target)) {
                        sb.append(group.getKey()).append('\n');
                    }
                }
            }
        }
    }

    System.out.println(sb);

  }
}
