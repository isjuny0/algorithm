import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Character> leftDeque = new ArrayDeque<>();
        Deque<Character> rightDeque = new ArrayDeque<>();

        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            leftDeque.addLast(str.charAt(i));;
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("P")) {
                char c = st.nextToken().charAt(0);
                leftDeque.addLast(c);
            }
            else if (cmd.equals("L")) {
                if (!leftDeque.isEmpty()) {
                    rightDeque.addFirst(leftDeque.pollLast());
                }
            }
            else if (cmd.equals("D")) {
                if (!rightDeque.isEmpty()) {
                    leftDeque.addLast(rightDeque.pollFirst());
                }
            }
            else if (cmd.equals("B")) {
                if (!leftDeque.isEmpty()) {
                    leftDeque.pollLast();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!leftDeque.isEmpty()) {
            sb.append(leftDeque.pollFirst());
        }
        while (!rightDeque.isEmpty()) {
            sb.append(rightDeque.pollFirst());
        }
        System.out.println(sb.toString());
    }
}