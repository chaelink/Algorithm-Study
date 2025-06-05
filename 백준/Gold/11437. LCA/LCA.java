import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] tree;
    static int[] parent;
    static int[] depth;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) tree[i] = new ArrayList<>();

        // 간선 입력 받기
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        parent = new int[N + 1];
        depth = new int[N + 1];
        visited = new boolean[N + 1];

        // 루트는 1번 노드
        dfs(1, 0);

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 쿼리 처리
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            sb.append(lca(u, v)).append("\n");
        }

        System.out.print(sb);
    }

    // DFS로 부모와 깊이 채우기
    static void dfs(int current, int d) {
        visited[current] = true;
        depth[current] = d;

        for (int next : tree[current]) {
            if (!visited[next]) {
                parent[next] = current;
                dfs(next, d + 1);
            }
        }
    }

    // LCA 찾기
    static int lca(int a, int b) {
        // 깊이를 같게 맞춤
        while (depth[a] > depth[b]) a = parent[a];
        while (depth[b] > depth[a]) b = parent[b];

        // 공통 조상 만날 때까지 위로 이동
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }
}
