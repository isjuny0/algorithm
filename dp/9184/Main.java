import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // d[a][b][c] : w(a, b, c) 결과를 저장
        int[][][] d = new int[51][51][51];

        // 초기화
        for (int i = 0; i <= 50; i++) {
            for (int j = 0; j <= 50; j++) {
                for (int k = 0; k <= 50; k++) {
                    if (i == 0 || j == 0 || k == 0) d[i][j][k] = 1;
                }
            }
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // #1 예외 처리
            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            // #2 예외 처리
            if (a <= 0 || b <= 0 || c <= 0) {
                sb.append("w("+a+", "+b+", "+c+") = 1").append("\n");
                continue;
            }

            sb.append("w("+a+", "+b+", "+c+") = ");

            if (a > 20 || b > 20 || c > 20) {
                a = 20;
                b = 20;
                c = 20;
            }

            for (int i = 1; i <= a; i++) {
                for (int j = 1; j <= b; j++) {
                    for (int k = 1; k <= c; k++) {
                        if (d[i][j][k] != 0) {
                            continue;
                        }
                        if (i < j && j < k) {
                            d[i][j][k] = d[i][j][k-1] + d[i][j-1][k-1] - d[i][j-1][k];
                        }
                        else {
                            d[i][j][k] = d[i-1][j][k] + d[i-1][j-1][k] + d[i-1][j][k-1] - d[i-1][j-1][k-1];
                        }
                    }
                }
            }
            sb.append(d[a][b][c]).append("\n");
        }
        System.out.println(sb.toString());
    }
}