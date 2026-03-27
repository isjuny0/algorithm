import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] isUsed;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        isUsed = new boolean[N];
        result = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        func(0);
        System.out.println(sb.toString());
    }

    private static void func(int k) {
        // base condition
        if (k == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                result[k] = arr[i];
                func(k + 1);
                isUsed[i] = false;
            }
        }
    }
}