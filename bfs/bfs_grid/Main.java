import java.io.*;
import java.util.*;

public class Main {
    static int row, col;
    static int[][] matrix;
    static boolean[][] visited;

    // 4방향으로 탐색하기 위한 x와 y의 delta 값
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        matrix = new int[row][col];
        visited = new boolean[row][col];

        // 2차원 배열 저장
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs(0, 0);
        System.out.println(result);
    }

    private static int bfs(int x, int y) {
        Deque<int[]> q = new ArrayDeque<>();

        // 초기 x좌표, y좌표, 거리
        q.offer(new int[] {x, y, 0});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] curr = q.poll();

            if (curr[0] == row-1 && curr[1] == col-1) {
                return curr[2];
            }

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                // 상하좌우로 새로 이동한 좌표가 2차원 배열의 범위를 벗어나는 지 체크
                // 갈 수 있는 곳 인지 체크
                // 방문한 적이 있는 지 체크
                if (nx >= 0 && nx < row && ny >= 0 && ny < col && matrix[nx][ny] == 1 && !visited[nx][ny]) {
                    q.offer(new int[] {nx, ny, curr[2] + 1});
                    visited[nx][ny] = true;
                }
            }
        }

        // 도달하지 못한 경우
        return -1;
    }
}