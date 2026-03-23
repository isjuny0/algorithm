import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr = new int[10];
    static boolean[] isUsed = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        func(0);
    }

    static void func(int k) {
        // base condition
        if (k == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (k == 0 || (!isUsed[i] && arr[k-1] < i)) {
                arr[k] = i;
                isUsed[i] = true;
                func(k+1);
                isUsed[i] = false;
                arr[k] = 0;
            }
        }
    }
}