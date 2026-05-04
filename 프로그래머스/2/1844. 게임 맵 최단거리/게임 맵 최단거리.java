import java.util.*;

//최단거리는 bfs
class Solution {
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    public int solution(int[][] maps) {
        int n =  maps.length;
        int m = maps[0].length;
        //int answer = 0;
        int[][] visited = new int[n][m];
        visited[0][0] = 1;
        
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{0,0,0});
        
        while(!q.isEmpty()) {
            Integer[] now = q.remove();
            if(now[0]==n-1 && now[1]==m-1) {
                return now[2]+1;
            }
            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m) {
                    if(visited[nx][ny]==0 && maps[nx][ny]==1) {
                        visited[nx][ny] = 1;
                        q.add(new Integer[]{nx,ny,now[2]+1});
                    }
                }
            }
        }
        
        return -1;
    }
}