import java.util.*;
class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        int n = maps.length; int m = maps[0].length();
        int[][] visit = new int[n][m];
        int[] dx = {0,0,1,-1}; int[] dy = {1,-1,0,0};
        //최대한 빠르게 탈출 -> bfs
        Queue<int[]> q = new ArrayDeque<>();
        
        //시작 지점 찾기
        a:
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(maps[i].charAt(j)=='S') {
                    q.add(new int[]{i,j,0});
                    visit[i][j] = 1;
                    break a;
                }
            }
        }
        
        boolean get = false;
        //시작 -> 레버
        while(!q.isEmpty()) {
            int[] now = q.poll();
            if(maps[now[0]].charAt(now[1])=='L') {
                get = true;
                q.clear();
                q.add(now);
                break;
            }
            
            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                
                if(nx>=0 && nx<n && ny>=0 && ny<m && visit[nx][ny]==0 && maps[nx].charAt(ny)!='X') {
                    visit[nx][ny] = 1;
                    q.add(new int[]{nx,ny,now[2]+1});
                }
            }
            
            
        }
        
        if(!get) return -1;
        
        //레버 -> 출구
        while(!q.isEmpty()) {
            int[] now = q.poll();
            if(maps[now[0]].charAt(now[1])=='E') {
                return now[2];
            }
            
            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                
                if(nx>=0 && nx<n && ny>=0 && ny<m && visit[nx][ny]!=2 && maps[nx].charAt(ny)!='X') {
                    visit[nx][ny] = 2;
                    q.add(new int[]{nx,ny,now[2]+1});
                }
            }      
        }
        
        return -1;
    }
}