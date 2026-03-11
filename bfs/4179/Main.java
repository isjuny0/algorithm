import java.io.*;
import java.util.*;

public class Main {
    static int row, col;
    static char[][] matrix;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static Deque<int[]> q = new ArrayDeque<>();
    static Deque<int[]> q_fire = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        matrix = new char[row][col];
        visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            String s = br.readLine();
            for (int j = 0; j < col; j++) {
                matrix[i][j] = s.charAt(j);
                if (matrix[i][j] == 'J') {
                    q.offer(new int[] {i, j, 1});
                    visited[i][j] = true;
                }
                if (matrix[i][j] == 'F') {
                    q_fire.offer(new int[] {i, j});
                }
            }
        }

        int result = bfs();
        if (result == -1) {
            System.out.println("IMPOSSIBLE");
        }
        else {
            System.out.println(result);
        }
    }

    private static int bfs() {

        while (!q.isEmpty()) {
            int curr_q_size = q.size();

            // 불이 확산하기 전 지훈이 이동가능한 위치
            for (int i = 0; i < curr_q_size; i++) {
                int[] curr = q.poll();

                // 이동한 위치가 불이 확산된 자리일 경우 큐 소모
                if (matrix[curr[0]][curr[1]] == 'F') continue;

                // 가장자리 도달
                if (curr[0] == 0 || curr[1] == 0 ||curr[0] == row - 1 || curr[1] == col - 1) return curr[2];

                for (int j = 0; j < 4; j++) {
                    int nx = curr[0] + dx[j];
                    int ny = curr[1] + dy[j];
                    if (nx >= 0 && nx < row && ny >= 0 && ny < col && matrix[nx][ny] == '.' && !visited[nx][ny]) {
                        q.offer(new int[] {nx, ny, curr[2] + 1});
                        visited[nx][ny] = true;
                    }
                }
            }

            int q_fire_size = q_fire.size();
            // 불 확산
            for (int i = 0; i < q_fire_size; i++) {
                int[] curr_fire = q_fire.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = curr_fire[0] + dx[j];
                    int ny = curr_fire[1] + dy[j];
                    if (nx >= 0 && nx < row && ny >= 0 && ny < col
                            && (matrix[nx][ny] == '.' || matrix[nx][ny] == 'J')) {
                        q_fire.offer(new int[] {nx, ny});
                        matrix[nx][ny] = 'F';
                    }
                }
            }
        }
        return -1;
    }
}