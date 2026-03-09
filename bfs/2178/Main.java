import java.io.*;
import java.util.*;

public class Main {
    static int[][] matrix;
    static int N;
    static int M;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = s.charAt(j) - '0';   // 입력이 붙어있는 경우 숫자 분리
            }
        }

        System.out.println(bfs(0, 0));
    }

    private static int bfs(int x, int y) {
        Deque<int[]> q = new ArrayDeque<>();

        q.offer(new int[] {x, y, 1});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (curr[0] == N-1 && curr[1] == M-1) {
                return curr[2];
            }

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && matrix[nx][ny] == 1 && !visited[nx][ny]) {
                    q.offer(new int[] {nx, ny, curr[2] + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }
}