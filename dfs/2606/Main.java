import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < n+1; i++) {
            list.add(new ArrayList<>());
        }
        visited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(u).add(v);
            list.get(v).add(u);
        }

        System.out.println(dfs());
    }

    private static int dfs() {
        Deque<Integer> stack = new ArrayDeque<>();
        int count = 0;

        stack.push(1);
        visited[1] = true;

        while (!stack.isEmpty()) {
            int u = stack.pop();

            for (int v : list.get(u)) {
                if (!visited[v]) {
                    stack.push(v);
                    visited[v] = true;
                    count++;
                }
            }
        }
        return count;
    }
}