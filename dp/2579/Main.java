import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        // d[2], d[3] 초기값 설정시 런타임 에러 (ArrayIndexOutOfBounds) 발생하지 않게 하기 위해 미리 예외 처리
        if (n == 1) {
            System.out.println(score[1]);
            return;
        }
        if (n == 2) {
            System.out.println(score[1] + score[2]);
            return;
        }

        // d[i] -> i번째 계단에 도착했을 때의 최대 점수
        // d[i] = Math.max(d[i-2] + score[i], d[i-3] + score[i-1] + score[i])
        int[] d = new int[n + 1];
        d[0] = 0;
        d[1] = score[1];
        d[2] = score[1] + score[2];
        d[3] = Math.max(score[1] + score[3], score[2] + score[3]);

        for (int i = 4; i <= n; i++) {
            d[i] = Math.max(d[i-2] + score[i], d[i-3] + score[i-1] + score[i]);
        }

        System.out.println(d[n]);
    }
}