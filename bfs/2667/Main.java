import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] matrix;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                matrix[i][j] = s.charAt(j) - '0';
            }
        }

        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    int result = bfs(i, j);
                    list.add(result);
                    count++;
                }
            }
        }
        Collections.sort(list);
        System.out.println(count);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        };
    }

    private static int bfs(int x, int y) {
        Deque<int[]> q = new ArrayDeque<>();
        int count = 0;

        q.offer(new int[] {x, y});
        visited[x][y] = true;
        count++;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                if (nx >=0 && nx < N && ny >= 0 && ny < N && matrix[nx][ny] == 1 && !visited[nx][ny]) {
                    q.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                    count ++;
                }
            }
        }

        return count;
    }
}