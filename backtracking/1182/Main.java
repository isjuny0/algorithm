import java.io.*;
import java.util.*;

public class Main{
    static int N, S, count = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        func(0, S);
        System.out.println(count);
    }

    private static void func(int k, int s) {
        // base condition
        if (s == 0 && k > 0) {
            count++;
        }

        for (int i = k; i < N; i++) {
            func(i+1, s - arr[i]);
        }
    }
}