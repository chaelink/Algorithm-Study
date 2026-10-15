import java.util.*;
class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        //사각형을 50*50 배열에, 이동 가능 루트를 1, 내부는 2
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int[][] arr = new int[51*5][51*5];
        for(int[] a : rectangle) {
            int x1 = a[0]*5;
            int y1 = a[1]*5;
            int x2 = a[2]*5;
            int y2 = a[3]*5;
            for(int i=x1; i<=x2; i++) {
                for(int j=y1; j<=y2; j++) {
                    if(arr[i][j]!=2) arr[i][j] = 1;
                }
            }
            for(int i=x1+1; i<x2; i++) {
                for(int j=y1+1; j<y2; j++) {
                    arr[i][j] = 2;
                }
            }
        }
        
        int[][] visit = new int[51*5][51*5];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{characterX*5,characterY*5,0});
        visit[characterX*5][characterY*5] = 1;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            if(now[0]==itemX*5 && now[1]==itemY*5) {
                return now[2]/5;
            }
            
            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx>0 && nx<=50*5 && ny>0 && ny<=50*5 && visit[nx][ny] == 0 && arr[nx][ny]==1) {
                    q.add(new int[]{nx,ny,now[2]+1});
                    visit[nx][ny] =1;
                }
            }
        }
        
        return 0;
    }
}