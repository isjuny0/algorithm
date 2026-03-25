import java.io.*;
import java.util.*;

public class Main {
    static int n, count;
    static boolean[] isUsedCol;
    static boolean[] isUsedDownDiagonal; // 왼 위 - 오른 아래
    static boolean[] isUsedUpDiagonal; // 왼 아래 - 오른 위

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        isUsedCol = new boolean[n];
        isUsedDownDiagonal = new boolean[2*n - 1];
        isUsedUpDiagonal = new boolean[2*n - 1];

        func(0);
        System.out.println(count);
    }

    private static void func(int k) {
        // base condition
        if (k == n) {
            count++;
            return;
        }

        // k행의 열 정하기
        for (int i = 0; i < n; i++) {
            if (!isUsedCol[i] && !isUsedDownDiagonal[k-i+n-1] && !isUsedUpDiagonal[k+i]) {
                isUsedCol[i] = true;
                isUsedDownDiagonal[k-i+n-1] = true;
                isUsedUpDiagonal[k+i] = true;
                func(k+1);
                isUsedCol[i] = false;
                isUsedDownDiagonal[k-i+n-1] = false;
                isUsedUpDiagonal[k+i] = false;
            }
        }
        return;
    }
}