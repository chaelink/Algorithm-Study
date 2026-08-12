import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        
        //가장 빠른 방법 -> bfs 사용
        int n = maps.length;
        int m = maps[0].length;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        
        int[][] arr = new int[n][m];
        
        Queue<int[]> q = new ArrayDeque<>();
        arr[0][0] = 1;
        
        q.add(new int[]{0,0});
        
        while(!q.isEmpty()) {
            int[] now = q.remove();
            
            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && maps[nx][ny]==1 && arr[nx][ny]==0) {
                    arr[nx][ny] = arr[now[0]][now[1]] +1;
                    q.add(new int[]{nx,ny});
                }
            }
        }
        
        if(arr[n-1][m-1]==0) {
            return -1;
        } else {
            return arr[n-1][m-1];
        }
    }
}