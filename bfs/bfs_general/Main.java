import java.io.*;
import java.util.*;

public class Main {
    static int size, edge;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 그래프의 노드, 간선 수 저장
        StringTokenizer st = new StringTokenizer(br.readLine());

        size = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());

        visited = new boolean[size+1];
        for (int i = 0; i <= size; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.get(start).add(end);
            // 양방향 그래프인 경우 인접 리스트에 아래처럼 간선 추가
            // list.get(end).add(start);
        }

        // 1번 노드부터 시작해서 9번 노드까지의 최단 거리
        int result = bfs(1, 9);
        System.out.println(result);
    }

    private static int bfs(int i, int j) {
        Deque<int[]> q = new ArrayDeque<>();

        q.offer(new int[] {i, 0});
        visited[i] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (curr[0] == j) {
                return curr[1];
            }

            for (int search : list.get(curr[0])) {  // 추출한 노드의 인접한 노드들 전부 방문
                if (!visited[search]) {
                    q.offer(new int[] {search, curr[1]+1});
                    visited[search] = true;
                }
            }
        }
        return -1;
    }
}