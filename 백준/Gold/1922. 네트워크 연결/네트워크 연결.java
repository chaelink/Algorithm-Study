import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int[] parent;
    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]); // 경로 압축
    }

    // union 연산 - 두 노드를 연결
    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return false; // 이미 연결되어 있으면 false
        parent[rootB] = rootA; // 병합
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Edge> edges = new ArrayList<>();
        parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int from = Integer.parseInt(line[0]);
            int to = Integer.parseInt(line[1]);
            int weight = Integer.parseInt(line[2]);
            edges.add(new Edge(from, to, weight));
        }

        Collections.sort(edges);
        int total = 0;
        int computer=0;

        for (Edge e : edges) {
            if (union(e.from, e.to)) {
                total += e.weight;
                computer++;
            }
            if (computer == n- 1) {
                break;
            }
        }
        System.out.println(total);
    }
}
