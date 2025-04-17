import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] nodeVals;
    static long[] dp;
    static List<List<Integer>> tree = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        nodeVals = new int[n];
        dp = new long[n];

        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        // 간선 입력 (양방향)
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            tree.get(p).add(c);
            tree.get(c).add(p);
        }

        // 노드 값 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nodeVals[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, -1);  // 루트 = 0번, 부모 없음
        System.out.println(dp[0]);
    }

    static void dfs(int current, int parent) {
        dp[current] = nodeVals[current];

        for (int child : tree.get(current)) {
            if (child == parent) continue;

            dfs(child, current);
            dp[current] += Math.max(0, dp[child]);
        }
    }
}
