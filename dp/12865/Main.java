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

        /* 점화식
           f(i,k) = if i=0, K=0: 0
                    if w[i] > K: f(i-1, k)
                    if 0 < i and w[i] <= K: max(f(i-1, K-w[i]) + v[i], f(i-1, K))
         */
        int[] d = new int[K+1];

        for (int i = 1; i <= N; i++) {
            // 중복 탐색 제거(i번째 물건에 대해 넣을 수 있는 경우만)
            for (int j = K; j - w[i] >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);

//            불필요한 탐색 포함
//            for (int j = 1; j <= K; j++) {
//
//                // i번째 무게를 더 담을 수 없는 경우
//                if (w[i] > j) {
//                    dp[i][j] = dp[i-1][j];
//                }
//
//                // i번째 무게를 더 담을 수 있는 경우
//                else {
//                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]] + v[i]);
//                }
//            }
            }
        }
    }

    // top-down
//    private static int knapsack(int i, int k) {
//        if (i < 0)
//            return 0;
//
//        if (dp[i][k] == null) {
//
//            // 현재 물건(i)를 추가로 못담는 경우(이전 i값 탐색)
//            if (w[i] > k) {
//                dp[i][k] = knapsack(i-1, k);
//            }
//            // 현재 물건(i)를 담을 수 있는 경우
//            else if (w[i] <= k) {
//                dp[i][k] = Math.max(knapsack(i-1, k), knapsack(i-1, k-w[i] + v[i]));
//            }
//        }
//        return dp[i][k];
//    }
}