import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();
        int next = 1;

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());

            while (next <= a) {
                stack.push(next);
                sb.append("+\n");
                next++;
            }

            if (!stack.isEmpty() && stack.peek() == a) {
                stack.pop();
                sb.append("-\n");
            }
            else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb.toString());
    }
}