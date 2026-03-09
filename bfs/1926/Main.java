import java.io.*;
import java.util.*;

public class Main {
    static int row, col;
    static int matrix[][];
    static boolean visit[][];

    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        matrix = new int[row][col];
        visit = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        int max_area = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1 && !visit[i][j]){
                    int result = bfs(i, j);
                    cnt++;
                    if (result > max_area) {
                        max_area = result;
                    }
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max_area);
    }

    private static int bfs(int x1, int y1) {
        Queue<int[]> q= new ArrayDeque<>();
        int area = 0;

        q.offer(new int[] {x1, y1});
        visit[x1][y1] = true;
        area++;

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            for (int delta = 0; delta < 4; delta++) {
                int nx = poll[0] + dx[delta];
                int ny = poll[1] + dy[delta];

                if (nx >= 0 && nx < row && ny >= 0 && ny < col && matrix[nx][ny] == 1 && !visit[nx][ny]) {
                    q.offer(new int[] {nx, ny});
                    visit[nx][ny] = true;
                    area++;
                }
            }

            if (q.isEmpty()) {
                return area;
            }
        }
        return 0;
    }
}