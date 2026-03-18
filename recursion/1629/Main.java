import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(calculate(A, B, C));
    }

    private static long calculate(int a, int b, int c) {
        // b = 5
        // a * a = a^2, a^2 * a^2 = a^4, a^4 * a = a^5 -> cal(5) = cal(4) * a, cal(4) = cal(2) * cal(2)
        // b == 1 -> base condition, cal(1) = a
        if (b == 1) {
            return a % c;
        }
        long result = calculate(a, b/2, c);
        result = result * result % c;
        return b%2 == 0 ? result : result * a % c;
    }
}