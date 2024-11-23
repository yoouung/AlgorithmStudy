import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static int[] parent;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    parent = new int[N + 1];
    for (int i = 0; i <= N; i++) {
      parent[i] = i;
    }

    // 진실을 이미 알고 있는 사람들
    st = new StringTokenizer(br.readLine());
    int knowTruth = Integer.parseInt(st.nextToken());

    if (knowTruth == 0) {
      // 진실을 알고 있는 사람이 0명일 경우, 파티의 개수가 곧 정답이다.
      System.out.println(M);
      return;
    }

    int[] truths = new int[knowTruth];
    for (int i = 0; i < knowTruth; i++) {
      truths[i] = Integer.parseInt(st.nextToken());
    }

    // 파티 정보 저장
    List<List<Integer>> parties = new ArrayList<>();
    for (int i = 0; i < M; i++) {
      parties.add(new ArrayList<>());

      st = new StringTokenizer(br.readLine());
      int pplNum = Integer.parseInt(st.nextToken());

      int first = Integer.parseInt(st.nextToken());
      parties.get(i).add(first);

      for (int j = 1; j < pplNum; j++) {
        int second = Integer.parseInt(st.nextToken());
        union(first, second);
        parties.get(i).add(second);
        first = second; // 뒷 사람들이랑 계속 비교
      }
    }

    // 진실을 아는 사람들과 연결된 모든 사람을 같은 그룹으로 묶기
    for (int i = 1; i < truths.length; i++) {
      union(truths[0], truths[i]);
    }

    // 거짓말 할 수 있는 파티 계산
    int count = 0;
    for (List<Integer> party : parties) {
      boolean canLie = true;
      for (int person : party) {
        if (find(person) == find(truths[0])) {
          canLie = false;
          break;
        }
      }
      if (canLie) count++;
    }

    System.out.println(count);
  }

  static void union(int x, int y) { // 부모 노드 업데이트
    int rootX = find(x);
    int rootY = find(y);
    if (rootX != rootY) {
      parent[rootY] = rootX;
    }
  }

  static int find(int x) { // 경로 압축
    if (parent[x] == x) return x;
    return find(parent[x]);
  }
}
