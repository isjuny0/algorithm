import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];

        for (int i = 0; i < N+1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
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

        for (int u = 1; u < N + 1; u++) {
            if (!visited[u]) {
                stack.push(u);
                visited[u] = true;

                while (!stack.isEmpty()) {
                    int curr = stack.pop();

                    for (int v : list.get(curr)) {
                        if (!visited[v]) {
                            stack.push(v);
                            visited[v] = true;
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
}