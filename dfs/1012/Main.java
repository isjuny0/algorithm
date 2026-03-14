import java.io.*;
import java.util.*;

public class Main {
    static int M, N, K;
    static int[][] matrix;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            matrix = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    matrix[i][j] = 0;
                }
            }
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                matrix[y][x] = 1;
            }
            System.out.println(dfs());
        }
    }

    private static int dfs() {
        int count = 0;
        Deque<int[]> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    stack.push(new int[] {i, j});
                    visited[i][j] = true;

                    while (!stack.isEmpty()) {
                        int[] curr = stack.pop();

                        for (int k = 0; k < 4; k++) {
                            int nx = curr[0] + dx[k];
                            int ny = curr[1] + dy[k];

                            if (nx >= 0 && ny >= 0 && nx < N && ny < M && matrix[nx][ny] == 1 && !visited[nx][ny]) {
                                stack.push(new int[] {nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                    count++;
                }
            }
        }

        return count;
    }
}