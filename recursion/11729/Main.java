import java.io.*;
import java.util.*;
import java.math.*;

// 미해결 -> 해설 참조본
public class Main {
    static StringBuilder sb =new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println((int)Math.pow(2, N) - 1);
        hanoi(1, 3, N);
    }

    // 기둥 a, b, 6-a-b / 원판 n개를 a번 기둥에서 b번 기둥으로 옮기는 방법을 출력하는 함수
    private static void hanoi(int a, int b, int n) {
        // base condition
        if (n == 1) {
            System.out.println(a + " " + b);
            return;
        }

        // case1: n-1개의 원판을 기둥 a에서 기둥 6-a-b로 옮긴다.
        hanoi(a, 6-a-b, n-1);
        // case2: n번 원판을 기둥 a에서 기둥 b로 옮긴다.
        System.out.println(a + " " + b);
        // case3: n-1개의 원판을 기둥 6-a-b에서 기둥 b로 옮긴다.
        hanoi(6-a-b, b, n-1);
    }
}