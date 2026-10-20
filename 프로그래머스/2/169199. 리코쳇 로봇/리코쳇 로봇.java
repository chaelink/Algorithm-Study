import java.util.*;
class Solution {
    public int solution(String[] board) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length();
        int[] dx = {0,0,1,-1}; int[] dy = {1,-1,0,0};
        int[][] visit = new int[n][m];
        
        //최소 몇번 -> bfs
        Queue<int[]>q = new ArrayDeque<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i].charAt(j)=='R') {
                    q.add(new int[]{i,j,0});
                    visit[i][j] = 1;
                    break;
                }
            }
        }
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            if(board[now[0]].charAt(now[1])=='G') {
                return now[2];
            }
            
            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                while(nx>=0 && nx<n && ny>=0 && ny<m && board[nx].charAt(ny)!='D') {
                    nx += dx[i];
                    ny += dy[i];
                }
                nx -= dx[i];
                ny -= dy[i];
                if(visit[nx][ny]==0) {
                    visit[nx][ny]=1;
                    q.add(new int[]{nx,ny,now[2]+1});
                }
            }
        }
          
        return -1;
    }
}