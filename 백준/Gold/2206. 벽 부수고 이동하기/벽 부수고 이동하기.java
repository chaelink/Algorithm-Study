

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        int[][][] visited = new int[n][m][2];  //x,y,벽 뿌수기 사용여부 0,1
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        q.add(new int[]{0,0,1,0});  //x,y,time,뿌수기여부
        visited[0][0][0] = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int x = cur[0]; int y = cur[1]; int t = cur[2]; int bomb = cur[3];
                if(x == n-1 && y == m-1){
                    System.out.println(t);
                    return;
                }

                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k]; int ny = y + dy[k];
                    if(nx>=0 && nx<n && ny>=0 && ny<m && arr[nx][ny]==0 && visited[nx][ny][bomb]==0){
                        q.add(new int[]{nx,ny,t+1,bomb});
                        visited[nx][ny][bomb] = 1;
                    }
                }
                if(bomb==0) {
                    for (int k = 0; k < 4; k++) {
                        int nx = x + dx[k]; int ny = y + dy[k];
                        if(nx>=0 && nx<n && ny>=0 && ny<m && arr[nx][ny]==1 && visited[nx][ny][bomb]==0){
                            q.add(new int[]{nx,ny,t+1,1});
                            visited[nx][ny][1] = 1;
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
