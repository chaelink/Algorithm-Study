import java.io.*;
import java.util.*;

public class Main {
    static int r,c,maxLen;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static char[][] arr;
    static boolean[] visited = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];

        for (int i = 0; i < r; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                arr[i][j] = s[j].charAt(0);
            }
        }
        dfs(0,0,1);
        System.out.println(maxLen);
    }

    public static void dfs(int i, int j, int depth) {
        int alpaIdx = arr[i][j] - 'A';
        visited[alpaIdx] = true;
        maxLen = Math.max(maxLen, depth);

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if(nx>=0 && nx<r && ny>=0 && ny<c) {
                int nextAlpaIdx = arr[nx][ny] - 'A';
                if(!visited[nextAlpaIdx]) {
                    dfs(nx, ny, depth+1);
                    visited[nextAlpaIdx] = false;
                }
            }
        }
    }
}