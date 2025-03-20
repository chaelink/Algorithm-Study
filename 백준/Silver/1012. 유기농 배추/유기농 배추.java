import java.util.*;

public class Main {
static int[][] arr;
static int[] dx = {1,-1,0,0};
static int[] dy = {0,0,1,-1};
static boolean[][] visited;
static int n;
static int m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            m = sc.nextInt();
            n = sc.nextInt();
            arr = new int[n][m];
            visited = new boolean[n][m];
            int k = sc.nextInt();

            int a,b,count=0;
            for(int j = 0; j < k; j++){
                a = sc.nextInt(); b=sc.nextInt();
                arr[b][a] = 1;
            }

            for(int j = 0; j < n; j++){
                for(int l =0; l<m; l++) {
                    if(arr[j][l]==1 && !visited[j][l]){
                        dfs(j,l);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        for(int i=0; i<4; i++) {
            int nm = x + dx[i];
            int nn = y + dy[i];
            if(nm>=0 && nm<n && nn>=0 && nn<m && arr[nm][nn]==1 && !visited[nm][nn]) {
                dfs(nm,nn);
            }
        }
    }
}
