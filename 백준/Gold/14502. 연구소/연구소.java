import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int[][] copy;
    static int safe;
    static int n;
    static int m;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        safe = 0;
        arr = new int[n][m];

        //arr 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //1. 완전탐색으로 벽 3개 세우기
        //2. 벽 3개를 세웠다고 가정 후 바이러스 확산
        //3. 안전 구역 갯수 카운트, 업데이트

        go(0);
        System.out.println(safe);

    }
    public static void go(int k) {
        if(k==3) {
            copy = new int[n][m];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    copy[i][j] = arr[i][j];
                }
            }
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(arr[i][j]==2) {
                        dfs(i,j);
                    }
                }
            }
            count();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 0){
                    arr[i][j] = 1;
                    go(k+1);
                    arr[i][j] = 0;
                }
            }
        }
    }
    public static void dfs(int i, int j) {
        for(int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if(nx>=0 && nx<n && ny>=0 && ny<m && copy[nx][ny] == 0) {
                copy[nx][ny] = 2;
                dfs(nx, ny);
            }
        }
    }

    public static void count() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(copy[i][j] == 0) {
                    count++;
                }
            }
        }
//        System.out.println(count);
        safe = Math.max(count, safe);
    }
}
