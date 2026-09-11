import java.util.*;
class Solution {
    public int solution(String[] board) {
        int answer = 0;
        int n = board.length; //세로
        int m = board[0].length(); //가로
        int gx=0, gy=0, rx=0, ry=0;
        char[][] arr = new char[n][m];
        
        //arr 세팅
        for(int i=0; i<n; i++) {
            String str = board[i];
            for(int j=0; j<m; j++) {
                if(str.charAt(j)=='D') {
                    arr[i][j] = 'D';
                } else if(str.charAt(j)=='G') {
                    arr[i][j] = 'G';
                    gx = i; gy = j;
                } else if(str.charAt(j)=='R') {
                    arr[i][j] = 'R';
                    rx = i; ry = j;
                }
            }
        }
        
        int[][] visit = new int[n][m];
        
        Queue<int[]> q = new ArrayDeque<>();
        //위치, 위치, 이동 횟수
        q.add(new int[]{rx,ry,0});
        visit[rx][ry] = 1;
        int x,y;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        
        while(!q.isEmpty()) {
            int[] now = q.remove();
            x = now[0]; y = now[1];
            //정답 반환
            if(x==gx && y==gy) return now[2];
             
            //상하좌우로 가능한 끝까지 이동하기
            for(int d=0; d<4; d++) {
                int nx = x;
                int ny = y;
                
                //갈 수 있는 끝 지점(경계 안, 장애물 전)
                while(nx+dx[d]>=0 && nx+dx[d]<n && ny+dy[d]>=0 && ny+ dy[d]<m && arr[nx+dx[d]][ny+dy[d]]!='D') {
                    nx += dx[d];
                    ny += dy[d];
                }
                
                if(visit[nx][ny]==0) {
                    visit[nx][ny]=1;
                    q.add(new int[]{nx,ny,now[2]+1});
                }
            }
    
        }
        
        //도달하지 못한 경우
        return -1;
    }
}