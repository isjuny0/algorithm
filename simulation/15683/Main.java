import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static int n, m;
    static int[][] matrix;
    static List<int[]> cctv_pos = new ArrayList<>();
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if (matrix[i][j] > 0 && matrix[i][j] < 6) {
                    cctv_pos.add(new int[] {i, j, matrix[i][j]});
                }
            }
        }

        func(0);
        System.out.println(min);
    }

    /*
    cctv 위치를 큐에 저장해놓고 하나씩 꺼내면서 cctv 종류에 따라서 감시 가능한 영역 표시,
    cctv 방향을 바꿀 수 있으므로 모든 조합을 다 확인해야 함 -> 백트래킹
    모든 cctv를 감시 영역 확인 후의 사각지대 영역 크기와 최소 크기를 비교하여 작은 값 반환
    1번은 4방향
    2번은 2방향
    3번은 4방향
    4번은 4방향
    5번은 1방향
     */
    private static void func(int k) {
        if (k == cctv_pos.size()) {
            int curr_square = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == 0) {
                        curr_square++;
                    }
                }
            }
            min = Math.min(min, curr_square);
            return;
        }

        int[] curr = cctv_pos.get(k);
        int x =  curr[0];
        int y = curr[1];
        int cctv_num = curr[2];

        switch (cctv_num) {
            case 1:
                cctv1(k, x, y);
                break;
            case 2:
                cctv2(k, x, y);
                break;
            case 3:
                cctv3(k, x, y);
                break;
            case 4:
                cctv4(k, x, y);
                break;
            case 5:
                cctv5(k, x, y);
                break;
        }
    }

    // y + 1 / y - 1 / x - 1 / x + 1
    private static void cctv1(int k, int x, int y) {
        int[][] prev_matrix = save_prev_matrix();

        // x + 1
        check_down_direction(x, y);
        func(k + 1);
        return_to_prev_matrix(prev_matrix);

        // x - 1
        check_up_direction(x, y);
        func(k + 1);
        return_to_prev_matrix(prev_matrix);

        // y + 1
        check_right_direction(x, y);
        func(k + 1);
        return_to_prev_matrix(prev_matrix);

        // y - 1
        check_left_direction(x, y);
        func(k + 1);
        return_to_prev_matrix(prev_matrix);
    }

    // y + 1, y - 1 / x + 1, x - 1
    private static void cctv2(int k, int x, int y) {
        int[][] prev_matrix = save_prev_matrix();

        check_up_direction(x, y);
        check_down_direction(x, y);
        func(k + 1);
        return_to_prev_matrix(prev_matrix);

        check_right_direction(x, y);
        check_left_direction(x, y);
        func(k + 1);
        return_to_prev_matrix(prev_matrix);
    }

    // x - 1, y + 1 / y + 1, x + 1 / x + 1, y - 1 / y - 1, x - 1
    private static void cctv3(int k, int x, int y) {
        int[][] prev_matrix = save_prev_matrix();

        // x-1, y+1
        check_up_direction(x, y);
        check_right_direction(x, y);
        func(k + 1);
        return_to_prev_matrix(prev_matrix);

        // y+1, x+1
        check_right_direction(x, y);
        check_down_direction(x, y);
        func(k + 1);
        return_to_prev_matrix(prev_matrix);

        // x+1, y-1
        check_down_direction(x, y);
        check_left_direction(x, y);
        func(k + 1);
        return_to_prev_matrix(prev_matrix);

        // y-1, x-1
        check_left_direction(x, y);
        check_up_direction(x, y);
        func(k + 1);
        return_to_prev_matrix(prev_matrix);
    }

    // y - 1, x - 1, y + 1 / x - 1, y + 1, x + 1 / y + 1, x + 1, y - 1 / x + 1, y - 1, x - 1
    private static void cctv4(int k, int x, int y) {
        int[][] prev_matrix = save_prev_matrix();

        // y-1, x-1, y+1
        check_up_direction(x, y);
        check_left_direction(x, y);
        check_right_direction(x, y);
        func(k + 1);
        return_to_prev_matrix(prev_matrix);

        // x-1, y+1, x+1
        check_right_direction(x, y);
        check_down_direction(x, y);
        check_up_direction(x, y);
        func(k + 1);
        return_to_prev_matrix(prev_matrix);

        // y+1, x+1, y-1
        check_down_direction(x, y);
        check_left_direction(x, y);
        check_right_direction(x, y);
        func(k + 1);
        return_to_prev_matrix(prev_matrix);

        // x+1, y-1, x-1
        check_left_direction(x, y);
        check_down_direction(x, y);
        check_up_direction(x, y);
        func(k + 1);
        return_to_prev_matrix(prev_matrix);
    }

    private static void cctv5(int k, int x, int y) {
        int[][] prev_matrix = save_prev_matrix();

        check_up_direction(x, y);
        check_down_direction(x, y);
        check_left_direction(x, y);
        check_right_direction(x, y);
        func(k + 1);
        return_to_prev_matrix(prev_matrix);
    }

    private static int[][] save_prev_matrix() {
        int[][] prev_matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            prev_matrix[i] = matrix[i].clone();
        }
        return prev_matrix;
    }

    private static void return_to_prev_matrix(int[][] prev_matrix) {
        for (int i = 0; i < n; i++) {
            matrix[i] = prev_matrix[i].clone();
        }
    }

    // y + 1
    private static void check_right_direction(int x, int y) {
        for (int i = 1; i < m; i++) {
            int ny = y + i ;
            if (ny < 0 || ny >= m || matrix[x][ny] == 6) {
                break;
            }
            if (matrix[x][ny] == 1 || matrix[x][ny] == 2 || matrix[x][ny] == 3
                    || matrix[x][ny] == 4 || matrix[x][ny] == 5 || matrix[x][ny] == -1) continue;
            matrix[x][ny] = -1;
        }
    }

    // y - 1
    private static void check_left_direction(int x, int y) {
        for (int i = 1; i < m; i++) {
            int ny = y - i ;
            if (ny < 0 || ny >= m || matrix[x][ny] == 6) {
                break;
            }
            if (matrix[x][ny] == 1 || matrix[x][ny] == 2 || matrix[x][ny] == 3
                    || matrix[x][ny] == 4 || matrix[x][ny] == 5 || matrix[x][ny] == -1) continue;
            matrix[x][ny] = -1;
        }
    }

    // x + 1
    private static void check_down_direction(int x, int y) {
        for (int i = 1; i < n; i++) {
            int nx = x + i;
            if (nx < 0 || nx >= n || matrix[nx][y] == 6) {
                break;
            }
            if (matrix[nx][y] == 1 || matrix[nx][y] == 2 || matrix[nx][y] == 3
                    || matrix[nx][y] == 4 || matrix[nx][y] == 5 || matrix[nx][y] == -1) continue;
            matrix[nx][y] = -1;
        }
    }

    // x - 1
    private static void check_up_direction(int x, int y) {
        for (int i = 1; i < n; i++) {
            int nx = x - i;
            if (nx < 0 || nx >= n || matrix[nx][y] == 6) {
                break;
            }
            if (matrix[nx][y] == 1 || matrix[nx][y] == 2 || matrix[nx][y] == 3
                    || matrix[nx][y] == 4 || matrix[nx][y] == 5 || matrix[nx][y] == -1) continue;
            matrix[nx][y] = -1;
        }
    }
}