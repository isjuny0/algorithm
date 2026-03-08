import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while (N-- > 0) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int compare_cnt = 0;
        while (!pq.isEmpty()) {
            if (pq.size() == 1) {
                break;
            }
            int x = pq.poll();
            int y = pq.poll();
            compare_cnt += x;
            compare_cnt += y;
            pq.add(x + y);
        }

        System.out.println(compare_cnt);
    }
}