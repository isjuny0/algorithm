import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] matrix;
    static boolean[][] visited;

    static List<int[]> ripe_tomato = new ArrayList<>();

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];
        visited = new boolean[N][M];

        boolean zero_flag = false;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if (matrix[i][j] == 0) {
                    zero_flag = true;
                }
                if (matrix[i][j] == 1) {
                    // 익은 토마토 위치 저장
                    ripe_tomato.add(new int[] {i,j});
                }
            }
        }
        // 저장될 때부터 모두 익어있는 상태이면 0
        if (!zero_flag) {
            System.out.println(0);
            return;
        };

        int result = bfs_ripe_tomato();
        if (result == -1) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    private static int bfs_ripe_tomato() {
        Deque<int[]> q = new ArrayDeque<>();
        int min_day = 10;

        // 익은 토마토 위치에서 동시 시작
        for (int[] start : ripe_tomato) {
            q.offer(new int[] {start[0], start[1], 0});
            visited[start[0]][start[1]] = true;
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && matrix[nx][ny] == 0 && !visited[nx][ny]) {
                    q.offer(new int[] {nx, ny, curr[2]+1});
                    visited[nx][ny] = true;
                }
            }
            min_day = curr[2];
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && matrix[i][j] == 0) return -1;
            }
        }
        return min_day;
    }
}