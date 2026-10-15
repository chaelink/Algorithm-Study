import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int[][] visit = new int[n][m];
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0,1});
        visit[0][0] =1;
        
        //(n,m)까지 최단거리 -> bfs
        while(!q.isEmpty()) {
            int[] now = q.remove();
            if(now[0]==n-1 && now[1] == m-1) {
                return now[2];
            }
            
            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                
                if(nx>=0 && nx<n && ny>=0 && ny<m && maps[nx][ny]!=0 && visit[nx][ny]==0) {
                    q.add(new int[]{nx,ny,now[2]+1});
                    visit[nx][ny] =1;
                }
            }
        }
        
        //벽 때문에 도달하지 못하면 -1 반환
        return -1;        
    }
}