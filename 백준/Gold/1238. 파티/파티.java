import java.io.*;
import java.util.*;

public class Main {
    static int N, M, X;
    static List<int[]>[] graph;
    static List<int[]>[] reverseGraph;
    static int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        reverseGraph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new int[]{to, cost});
            reverseGraph[to].add(new int[]{from, cost});
        }

        int[] distToX = dijkstra(reverseGraph, X);
        int[] distFromX = dijkstra(graph, X);

        int max = 0;
        for (int i = 1; i <= N; i++) {
            int total = distToX[i] + distFromX[i];
            if (total > max) max = total;
        }

        System.out.println(max);
    }

    static int[] dijkstra(List<int[]>[] g, int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int now = curr[0], cost = curr[1];

            if (cost > dist[now]) continue;

            for (int[] next : g[now]) {
                int to = next[0], nextCost = next[1];
                if (dist[to] > dist[now] + nextCost) {
                    dist[to] = dist[now] + nextCost;
                    pq.offer(new int[]{to, dist[to]});
                }
            }
        }

        return dist;
    }
}
