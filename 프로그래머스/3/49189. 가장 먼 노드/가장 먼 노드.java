import java.util.*;

class Solution {
    
    public int solution(int n, int[][] edge) {
        //int edge2[][] = new int[n+1][n+1];
        int m = edge.length;
        ArrayList<ArrayList<Integer>> edge3 = new ArrayList<>();
        for(int i=0; i<m; i++) {
            edge3.add(new ArrayList<>());
        }
        
        for(int i=0; i<m; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            //edge2[a][b] = 1;
            //edge2[b][a] = 1;
            edge3.get(a).add(b);
            edge3.get(b).add(a);
        }
        
        
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Integer> q = new ArrayDeque<>();
        int visited[] = new int[n+1];
        
        q.add(1);
        visited[1] = 1;
        map.put(1,0);
      
        int maxn = 0;
        
        while(!q.isEmpty()) {
            int now = q.poll();
            for(int i : edge3.get(now)) {
                if(visited[i]==0) {
                    q.add(i);
                    visited[i] = 1;
                    map.put(i, map.get(now)+1);
                    maxn = Math.max(maxn, map.get(now)+1);
                }
            }
            // for(int i=1; i<=n; i++) {
            //     //if(edge2[now][i]==1 && visited[i]==0) {
            //         q.add(i);
            //         visited[i] = 1;
            //         map.put(i, map.get(now)+1);
            //         maxn = Math.max(maxn, map.get(now)+1);
            //     }
            
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == maxn) {
                answer++;
            }
        }
        return answer;
    }
}