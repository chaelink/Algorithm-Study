
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); int m = Integer.parseInt(input[1]); int k = Integer.parseInt(input[2]);
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        Queue<int[]> q = new LinkedList<>();
        int[][][] visited = new int[n][m][k+1];
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        q.add(new int[] {0,0,1,0}); //x,y,t,b
        visited[0][0][0] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int t = cur[2];
            int b = cur[3];

            if(x == n-1 && y == m-1){
                System.out.println(t);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && arr[nx][ny]==0 && visited[nx][ny][b]==0){
                    q.add(new int[]{nx,ny,t+1,b});
                    visited[nx][ny][b] = 1;
                }
            }
            if(b<k) {
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx>=0 && nx<n && ny>=0 && ny<m && arr[nx][ny]==1 && visited[nx][ny][b+1]==0){
                        q.add(new int[]{nx,ny,t+1,b+1});
                        visited[nx][ny][b+1] = 1;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
