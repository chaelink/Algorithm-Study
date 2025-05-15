import java.io.*;
import java.util.*;

public class Main {
    static int R, C, T;
    static int[][] arr;
    static int[][] temp;
    static int[] airCleaner = new int[2];
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[R][C];

        int airIndex = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == -1) {
                    airCleaner[airIndex++] = i;
                }
            }
        }

        while (T-- > 0) {
            spreadDust();
            cleanAir();
        }

        System.out.println(countDust());
    }

    static void spreadDust() {
        temp = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] > 0) {
                    int spreadAmount = arr[i][j] / 5;
                    int count = 0;

                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx >= 0 && ny >= 0 && nx < R && ny < C && arr[nx][ny] != -1) {
                            temp[nx][ny] += spreadAmount;
                            count++;
                        }
                    }

                    arr[i][j] -= spreadAmount * count;
                }
            }
        }

        // 확산 결과 반영
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                arr[i][j] += temp[i][j];
            }
        }
    }

    static void cleanAir() {
        int up = airCleaner[0];
        int down = airCleaner[1];

        // 위쪽: 반시계 방향
        for (int i = up - 1; i > 0; i--) arr[i][0] = arr[i - 1][0];
        for (int i = 0; i < C - 1; i++) arr[0][i] = arr[0][i + 1];
        for (int i = 0; i < up; i++) arr[i][C - 1] = arr[i + 1][C - 1];
        for (int i = C - 1; i > 1; i--) arr[up][i] = arr[up][i - 1];
        arr[up][1] = 0;

        // 아래쪽: 시계 방향
        for (int i = down + 1; i < R - 1; i++) arr[i][0] = arr[i + 1][0];
        for (int i = 0; i < C - 1; i++) arr[R - 1][i] = arr[R - 1][i + 1];
        for (int i = R - 1; i > down; i--) arr[i][C - 1] = arr[i - 1][C - 1];
        for (int i = C - 1; i > 1; i--) arr[down][i] = arr[down][i - 1];
        arr[down][1] = 0;
    }

    static int countDust() {
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] > 0) sum += arr[i][j];
            }
        }
        return sum;
    }
}
