import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int c = Integer.parseInt(br.readLine());

        for (int i = 0; i < c; i++) {
            Queue<Integer> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            // 문서 개수
            int N = Integer.parseInt(st.nextToken());
            // 궁금한 문서의 현재 위치(0부터)
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int order = 1;

            // queue에 입력 순서대로 문서 중요도를 저장
            for (int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken());

                queue.offer(x);
            }

            while(!queue.isEmpty()) {
                int max = cal_max(queue);

                // 가장 큰 중요도의 문서가 front로 오기전까지 뒤로 재배치
                while(queue.peek() != max) {
                    queue.offer(queue.poll());
                    M = M == 0 ? queue.size() - 1 : M - 1;
                }

                // queue.peek() == max 일 때 궁금한 문서일 경우
                if (M == 0) {
                    sb.append(order).append('\n');
                    break;
                }
                else {
                    queue.poll();
                    M--;
                    order++;
                }
            }
        }
        System.out.println(sb.toString());
    }

    // queue 안에서 가장 큰 중요도 계산
    static int cal_max(Queue<Integer> queue) {
        int max = 0;

        for (int i = 0; i < queue.size(); i++) {
            if (queue.peek() > max) {
                max = queue.peek();
            }
            queue.offer(queue.poll());
        }
        return max;
    }
}