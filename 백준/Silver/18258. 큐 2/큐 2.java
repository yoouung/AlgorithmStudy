import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // br 사용 시 IOException 예외처리 필수

        Deque<Integer> queue = new LinkedList<>(); // 덱 생성 (큐를 사용하면 마지막 요소 출력 못함)
        /*
         * 방법1. Deque<Integer> deq = new LinkedList<>();
         * 방법2. LinkedList<Ingeter> list = new LinkedList<>();
         */

        StringBuilder sb = new StringBuilder(); // 매번 출력하는 시간 최적화

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            
            if (input.contains("push")) {
                int x = Integer.parseInt(input.split(" ")[1]);
                queue.offer(x); // add: 예외발생, offer: 값 리턴
            } else {
                switch (input) {
                    case "pop":
                        sb.append(queue.isEmpty() ? -1 : queue.poll()).append("\n"); // remove: 예외발생, poll: 값 리턴
                        break;
                    case "size":
                        sb.append(queue.size()).append("\n");
                        break;
                    case "empty":
                        sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                        break;
                    case "front":
                        sb.append(queue.isEmpty() ? -1 : queue.peek()).append("\n"); // element: 예외발생, peek: 값 리턴
                        break;
                    case "back":
                        sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append("\n");
                        break;
                    
                }
            }
        }
        
        System.out.println(sb);
    }
}
