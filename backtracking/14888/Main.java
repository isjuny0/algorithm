import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static int[] op = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        func(1, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void func(int k, int result) {
        // base condition
        if (k == n) {
            if (max < result) {
                max = result;
            }
            if (min > result) {
                min = result;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (i == 0 && op[i] > 0) {
                op[i]--;
                func(k+1, result + arr[k]);
                op[i]++;
            }
            else if (i == 1 && op[i] > 0) {
                op[i]--;
                func(k+1, result - arr[k]);
                op[i]++;
            }
            else if (i == 2 && op[i] > 0) {
                op[i]--;
                func(k+1, result * arr[k]);
                op[i]++;
            }
            else if (i == 3 && op[i] > 0) {
                op[i]--;
                func(k+1, result / arr[k]);
                op[i]++;
            }
        }
    }
}