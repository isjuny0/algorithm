import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] d = new int[41][2]; // 0과 1의 횟수
        d[0][0] = 1;
        d[0][1] = 0;
        d[1][0] = 0;
        d[1][1] = 1;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (d[n][0] != 0 || d[n][1] != 0) {
                sb.append(d[n][0] + " " + d[n][1]).append("\n");
                continue;
            }

            for (int i = 2; i <= n; i++) {
                d[i][0] = d[i-2][0] + d[i-1][0];
                d[i][1] = d[i-2][1] + d[i-1][1];
            }

            sb.append(d[n][0] + " " + d[n][1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}