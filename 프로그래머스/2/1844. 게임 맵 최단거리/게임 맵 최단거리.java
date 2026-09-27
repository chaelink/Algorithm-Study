import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        int[][] visit = new int[n][m];
        
        //최대한 빨리 도착
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        
        //bfs, 큐에 넣고 빼서 거리 탐색
        Queue<Integer[]> q = new ArrayDeque<>();
        q.add(new Integer[]{0,0});
        visit[0][0] = 1;
        
        while(!q.isEmpty()) {
            Integer[] now = q.poll();
            if(now[0]==(n-1) && now[1]==(m-1)) {
                return visit[now[0]][now[1]];
            }
            
            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                
                if(nx>=0 && nx<n && ny>=0 && ny<m && maps[nx][ny]==1 && visit[nx][ny]==0) {
                    visit[nx][ny] = visit[now[0]][now[1]]+1;
                    q.add(new Integer[]{nx,ny});
                }
            }
        }
        
        //n-1, m-1에 도달 못하면
        return -1;
    }
}