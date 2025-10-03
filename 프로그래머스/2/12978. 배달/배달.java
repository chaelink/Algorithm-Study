import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        //그래프 저장
        List<List<Edge>> list = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
        }
        for(int i=0; i<road.length; i++) {
            int a = road[i][0]; int b = road[i][1]; int c = road[i][2];
            list.get(a).add(new Edge(b,c));
            list.get(b).add(new Edge(a,c));
        }
        
        //최종 시간 기록
        int[] time = new int[N+1];
        Arrays.fill(time, Integer.MAX_VALUE);
        
        Queue<int[]> q = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        //1번 마을에서 출발
        time[1] = 0;
        q.add(new int[]{1,0});
        
        //pq반복
        while(!q.isEmpty()) {
            int[] now = q.remove();
            
            if(time[now[0]] < now[1]) continue;
            
            for(Edge e : list.get(now[0])) {
                int nd = now[1] + e.to;
                if(nd < time[e.node]) {
                    time[e.node] = nd;
                    q.add(new int[]{e.node, nd});
                }
            }
            
        }
        for(int i=1; i<=N; i++) {
            if(time[i]<=K) answer++;
        }

        return answer;
    }
}

class Edge {
    public int node;
    public int to;
    
    public Edge(int node, int to) {
        this.node = node;
        this.to = to;
    }
}