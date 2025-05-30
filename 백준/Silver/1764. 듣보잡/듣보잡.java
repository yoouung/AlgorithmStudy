import java.util.*;
import java.io.*;

public class Main {
  /*
  처음 생각: 배열 2개 교집합 -> 사전순 정렬
  -> 배열.retailAll(배열2), Collections.sort(배열) : 시간초과

  ==> HasMap으로 누적 개수 저장하고, 개수 2인 것만 list에 따로 저장
  + 출력할 때 StringBuffer 쓰기
  */


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    HashMap<String, Integer> map = new HashMap<>();
    List<String> heardAndSeen = new ArrayList<>();

    for (int i=0; i<N; i++) {
      String name = br.readLine();
      map.put(name, map.getOrDefault(name, 0) + 1);
    }
    for (int i=0; i<M; i++) {
      String name = br.readLine();
      map.put(name, map.getOrDefault(name, 0) + 1);
      if (map.get(name) == 2) {
        heardAndSeen.add(name);
      }
    }

    Collections.sort(heardAndSeen);
    StringBuilder sb = new StringBuilder();
    for (String s : heardAndSeen) {
      sb.append(s).append("\n");
    }
    System.out.println(heardAndSeen.size());
    System.out.println(sb);
  }
}
