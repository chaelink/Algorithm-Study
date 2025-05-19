import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[] alpha = new int[26];
    static int maxLen = 0;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String[] s = st.nextToken().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = s[j].charAt(0);
            }
        }
        dfs(0,0,1);
        System.out.println(maxLen);
    }

    public static void dfs(int i, int j, int len) {
        maxLen = Math.max(maxLen, len);
        int num = arr[i][j] - 'A';
        alpha[num] = 1;

        for(int k=0; k<4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if(nx>=0 && ny>=0 && nx<n && ny<m) {
                int a = arr[nx][ny] - 'A';
                if(alpha[a]==0) {
                    dfs(nx,ny,len+1);
                    alpha[a] = 0;
                }
            }
        }

    }
}
