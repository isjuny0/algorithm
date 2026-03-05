import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("push")) {
                int x = Integer.parseInt(st.nextToken());
                queue.offer(x);
            }
            else if (cmd.equals("pop")) {
                sb.append(queue.isEmpty() ? -1 : queue.poll()).append('\n');
            }
            else if (cmd.equals("size")) {
                sb.append(queue.size()).append('\n');
            }
            else if (cmd.equals("empty")) {
                sb.append(queue.isEmpty() ? 1 : 0).append('\n');
            }
            else if (cmd.equals("front")) {
                sb.append(queue.isEmpty() ? -1 : queue.peek()).append('\n');
            }
            else if (cmd.equals("back")) {
                if (queue.isEmpty()) {
                    sb.append(-1).append('\n');
                }
                else {
                    for (int i = 0; i < queue.size() - 1; i++) {
                        int temp = queue.poll();
                        queue.offer(temp);
                    }
                    int back = queue.poll();
                    sb.append(back).append('\n');
                    queue.offer(back);
                }
            }
        }
        System.out.println(sb.toString());
    }
}