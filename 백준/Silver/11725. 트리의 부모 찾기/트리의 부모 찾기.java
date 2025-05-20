import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> tree = new ArrayList<>();
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

      
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int current) {
        visited[current] = true;
        for (int next : tree.get(current)) {
            if (!visited[next]) {
                parent[next] = current; // 부모 저장
                dfs(next);
            }
        }
    }
}
