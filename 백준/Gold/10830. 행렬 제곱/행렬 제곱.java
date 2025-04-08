import java.util.Scanner;

public class Main {
    static int MOD = 1000, N;
    static int[][] unitMatrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        long B = sc.nextLong();

        int[][] matrix = new int[N][N];
        unitMatrix = new int[N][N];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                matrix[i][j] = sc.nextInt() % MOD;

        for (int i = 0; i < N; i++)
            unitMatrix[i][i] = 1;

        matrix = powMatrix(B, matrix);

        for (int[] row : matrix) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }

    private static int[][] powMatrix(long exp, int[][] mat) {
        if (exp == 0) return unitMatrix;
        if (exp == 1) return mat;

        int[][] half = powMatrix(exp / 2, mat);
        int[][] result = multiplyMatrix(half, half);

        if (exp % 2 == 1)
            result = multiplyMatrix(result, mat);

        return result;
    }

    private static int[][] multiplyMatrix(int[][] mat1, int[][] mat2) {
        int[][] result = new int[N][N];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                for (int k = 0; k < N; k++)
                    result[i][j] = (result[i][j] + mat1[i][k] * mat2[k][j]) % MOD;

        return result;
    }
}
