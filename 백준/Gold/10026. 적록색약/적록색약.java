import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int normal = countAreas(false);
        int colorBlind = countAreas(true);

        System.out.println(normal + " " + colorBlind);
    }

    
    
    static int countAreas(boolean isColorBlind) {
        visited = new boolean[N][N];
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, map[i][j], isColorBlind);
                    count++;
                }
            }
        }
        return count;
    }

    static void dfs(int x, int y, char color, boolean isColorBlind) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                if (isColorBlind) {
                    if ((color == 'R' || color == 'G') && (map[nx][ny] == 'R' || map[nx][ny] == 'G')) {
                        dfs(nx, ny, color, isColorBlind);
                    } else if (map[nx][ny] == color) {
                        dfs(nx, ny, color, isColorBlind);
                    }
                } else {
                    if (map[nx][ny] == color) {
                        dfs(nx, ny, color, isColorBlind);
                    }
                }
            }
        }
        
    }
    
}
