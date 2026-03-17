import java.io.*;
import java.util.*;

public class Main {
    static int w, h;
    static int[][] matrix;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, 1, -1, -1, -1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 || h == 0) return;

            matrix = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (matrix[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(int x, int y) {
        Deque<int[]> stack = new ArrayDeque<>();

        stack.push(new int[] {x, y});
        visited[x][y] = true;

        while (!stack.isEmpty()) {
            int[] curr = stack.pop();

            for (int i = 0; i < 8; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx >= 0 && nx < h && ny >= 0 && ny < w && matrix[nx][ny] == 1 && !visited[nx][ny]) {
                    stack.push(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}