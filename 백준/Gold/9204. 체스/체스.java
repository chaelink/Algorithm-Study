import java.util.Scanner;

public class Main {
    static int sx, sy, ex, ey;
    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {1, -1, 1, -1};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tnum = input.nextInt();

        for (int t = 0; t < tnum; t++) {
            sy = input.next().charAt(0) - 'A' + 1;
            sx = 9 - input.nextInt();
            ey = input.next().charAt(0) - 'A' + 1;
            ex = 9 - input.nextInt();

            simulate();
        }
    }

    private static void simulate() {
        // 0회 이동
        if (sx == ex && sy == ey) {
            printResult(0, sx, sy);
            return;
        }

        // 색이 다르면 이동 불가
        if ((sx + sy) % 2 != (ex + ey) % 2) {
            System.out.println("Impossible");
            return;
        }

        // 1회 이동 가능한 경우 (같은 대각선 위에 있음)
        if (Math.abs(sx - ex) == Math.abs(sy - ey)) {
            printResult(1, sx, sy, ex, ey);
            return;
        }

        // 2회 이동 (교차점 찾아서 출력)
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                if (Math.abs(sx - i) == Math.abs(sy - j) && Math.abs(ex - i) == Math.abs(ey - j)) {
                    printResult(2, sx, sy, i, j, ex, ey);
                    return;
                }
            }
        }
    }

    private static void printResult(int move, int... positions) {
        System.out.print(move + " ");
        for (int i = 0; i < positions.length; i += 2) {
            int x = positions[i];
            int y = positions[i + 1];
            char col = (char) ('A' + y - 1);
            int row = 9 - x;
            System.out.print(col + " " + row + " ");
        }
        System.out.println();
    }
}
