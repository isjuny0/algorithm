import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int[] d = new int[11];
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            /*
            d[4] = d[1] + d[2] + d[3]
            d[1]: 이전에 저장된 값에 +3 하는 경우
            d[2]: 이전에 저장된 값에 +2 하는 경우
            d[3]: 이전에 자장된 값에 +1 하는 경우
            d[i] = d[i-1] + d[i-2] + d[i-3]
             */
            for (int i = 4; i <= n; i++) {
                d[i] = d[i - 1] + d[i - 2] + d[i - 3];
            }
            sb.append(d[n]).append("\n");
        }

        System.out.println(sb.toString());
    }
}