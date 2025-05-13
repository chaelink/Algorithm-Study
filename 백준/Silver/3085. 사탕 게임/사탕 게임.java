import java.io.*;

public class Main {
    static char[][] board;
    static int N;
    static int max = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        // 보드 입력
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            board[i] = line.toCharArray();
        }

        // 모든 인접 쌍 교환 → 최대 연속 사탕 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                // 가로 교환
                swap(i, j, i, j + 1);
                check();
                swap(i, j, i, j + 1); // 복구

                // 세로 교환
                swap(j, i, j + 1, i);
                check();
                swap(j, i, j + 1, i); // 복구
            }
        }

        System.out.println(max);
    }

    static void swap(int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    static void check() {
        for (int i = 0; i < N; i++) {
            int rowCount = 1;
            int colCount = 1;

            for (int j = 1; j < N; j++) {
                // 행 검사
                if (board[i][j] == board[i][j - 1]) {
                    rowCount++;
                } else {
                    rowCount = 1;
                }
                max = Math.max(max, rowCount);

                // 열 검사
                if (board[j][i] == board[j - 1][i]) {
                    colCount++;
                } else {
                    colCount = 1;
                }
                max = Math.max(max, colCount);
            }
        }
    }
}
