import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr = new int[10];
    static boolean[] isUsed = new boolean[10];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        func(0);
        System.out.println(sb.toString());
    }

    private static void func(int k) {
        // base condition
        if (k == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append('\n');
            isUsed[arr[k-1]] = true;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!isUsed[i]) {
                arr[k] = i;
                func(k + 1);
                isUsed[i] = false;
            }
        }
        return;
    }
}