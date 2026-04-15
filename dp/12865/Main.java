import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] w = new int[N+1];
        int[] v = new int[N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        // d[i] = 배낭이 i 무게일 때 최대 가치합
        int[] d = new int[K+1];
        for (int i = 1; i <= N; i++) {
            for (int j = K; j >= w[i]; j--) {
                d[j] = Math.max(d[j], d[j - w[i]] + v[i]);
            }
        }
        System.out.println(d[K]);
    }
}