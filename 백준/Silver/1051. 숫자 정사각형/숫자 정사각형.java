import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] dims = br.readLine().split(" ");
        int n = Integer.parseInt(dims[0]);
        int m = Integer.parseInt(dims[1]);

        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        int maxArea = 1;  

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int l = 1; i + l < n && j + l < m; l++) {
                    if (board[i][j] == board[i + l][j] &&
                        board[i][j] == board[i][j + l] &&
                        board[i][j] == board[i + l][j + l]) {
                        int area = (l + 1) * (l + 1);
                        maxArea = Math.max(maxArea, area);
                    }
                }
            }
        }

        System.out.println(maxArea);
    }
}
