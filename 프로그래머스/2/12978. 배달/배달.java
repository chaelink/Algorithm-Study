import java.util.*;
class Node implements Comparable<Node> {
    int to;
    int cost;
    
    public Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        //1번마을에서 각 마을로 음식 배달
        List<Node>[] list =  new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int[] r : road) {
            int a = r[0]; int b = r[1]; int c = r[2];
            list[a].add(new Node(b,c));
            list[b].add(new Node(a,c));
        }
        
        //결과 저장 배열
        int[] result = new int[N+1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[1] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        
        while(!pq.isEmpty()) {
            int start = pq.poll();
            
            for(Node n : list[start]) {
                if(result[n.to] <= result[start] + n.cost) {
                    continue;
                } else {
                    result[n.to] = result[start] + n.cost;
                    pq.add(n.to);
                }
            }
        }
        
        for(int i=1; i<=N; i++) {
            if(result[i]<=K) answer++;
        }

        return answer;
    }
}