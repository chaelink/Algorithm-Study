import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (true) {
            visited = new boolean[N][M];
            markOutsideAir();

            List<int[]> toMelt = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && shouldMelt(i, j)) {
                        toMelt.add(new int[]{i, j});
                    }
                }
            }

            if (toMelt.isEmpty()) {
                break;
            }

            for (int[] pos : toMelt) {
                map[pos[0]][pos[1]] = 0;
            }

            time++;
        }

        System.out.println(time);
    }

    static void markOutsideAir() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        map[0][0] = -1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!visited[nx][ny] && map[nx][ny] <= 0) {
                        visited[nx][ny] = true;
                        map[nx][ny] = -1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    static boolean shouldMelt(int x, int y) {
        int count = 0;
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (map[nx][ny] == -1) {
                    count++;
                }
            }
        }
        return count >= 2;
    }
}
