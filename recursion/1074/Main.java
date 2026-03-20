import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(cal_z(N, r, c));
    }

    // 더이상 안나눠질 때까지 4등분 해서 왼 위 - 오른 위 - 왼 아래 - 오른 아래 순 탐색
    // 1. (0, 0) / 2. (0, 2^(N-1)) / 3. (2^(N-1), 0) / 4. (2^(N-1), 2^(N-1))
    private static int cal_z(int N, int r, int c) {

        // #1
        if (r >= 0 && r < Math.pow(2, N-1) && c >= 0 && c < Math.pow(2, N-1)) {
            if (N == 1) {
                return 0;
            }
            return cal_z(N-1, r, c);
        }

        // #2
        else if (r >= 0 && r < Math.pow(2, N-1) && c >= Math.pow(2, N-1) && c < Math.pow(2, N)) {
            if (N == 1) {
                return 1;
            }
            return cal_z(N-1, r, c % (int)Math.pow(2, N-1)) + (int)Math.pow(Math.pow(2, N-1), 2);
        }

        // #3
        else if (r >= Math.pow(2, N-1) && r < Math.pow(2, N) && c >= 0 && c < Math.pow(2, N-1)) {
            if (N == 1) {
                return 2;
            }
            return cal_z(N-1, r % (int)Math.pow(2, N-1), c) + (int)Math.pow(Math.pow(2, N-1), 2) * 2;
        }

        // #4
        else if (r >= Math.pow(2, N-1) && r < Math.pow(2, N) && c >= Math.pow(2, N-1) && c < Math.pow(2, N)) {
            if (N == 1) {
                return 3;
            }
            return cal_z(N-1, r % (int)Math.pow(2, N-1), c % (int)Math.pow(2, N-1)) + (int)Math.pow(Math.pow(2, N-1), 2) * 3;
        }
        return -1;
    }
}