import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String c = st.nextToken();

            if (c.equals("push")) {
                int x = Integer.parseInt(st.nextToken());
                stack.push(x);
            }
            else if (c.equals("pop")) {
                sb.append(stack.empty() ? -1 : stack.pop()).append('\n');
            }
            else if (c.equals("top")) {
                sb.append(stack.empty() ? -1 : stack.peek()).append('\n');
            }
            else if (c.equals("size")) {
                sb.append(stack.size()).append('\n');
            }
            else if (c.equals("empty")) {
                sb.append(stack.empty() ? 1 : 0).append('\n');
            }
        }
        System.out.println(sb.toString());
    }
}