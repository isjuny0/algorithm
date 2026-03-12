import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] arr = new int [100001];
    static boolean[] visited = new boolean[100001];

    static int[] dx = {1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }

    private static int bfs() {
        Deque<int[]> q = new ArrayDeque<>();

        q.offer(new int[] {N, 0});
        visited[N] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (curr[0] == K) {
                return curr[1];
            }

            for (int i = 0; i < 3; i++) {
                int nx = -1;
                if (i == 2) {
                    nx = curr[0] * 2;
                } else {
                    nx = curr[0] + dx[i];
                }

                if (nx < arr.length && nx >= 0 && !visited[nx]) {
                    q.offer(new int[] {nx, curr[1] + 1});
                    visited[nx] = true;
                }
            }
        }
        return -1;
    }
}