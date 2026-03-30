import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        List<int[]>[] graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();
        for(int[] a : road) {
            graph[a[0]].add(new int[]{a[1], a[2]});
            graph[a[1]].add(new int[]{a[0], a[2]});
        }

        int[] result = new int[N+1];
        Arrays.fill(result, Integer.MAX_VALUE);

        // {비용, 마을번호} 비용 기준 오름차순
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        pq.add(new int[]{0, 1});
        result[1] = 0;

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int idx = curr[1];

            if(result[idx] < cost) continue; // 이미 더 싸게 방문

            for(int[] next : graph[idx]) {
                int nextIdx = next[0];
                int nextCost = cost + next[1];

                if(result[nextIdx] > nextCost) {
                    result[nextIdx] = nextCost;
                    pq.add(new int[]{nextCost, nextIdx});
                }
            }
        }

        for(int i=1; i<=N; i++) {
            if(result[i] <= K) answer++;
        }

        return answer;
    }
}