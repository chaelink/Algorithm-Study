import java.util.*;

public class Main {
    static int N, count = 0;
    static int[] queens; 
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        queens = new int[N];

        // 백트래킹
        dfs(0);
        
        System.out.println(count);
    }

    static void dfs(int row) {
        if (row == N) { 
            count++;
            return;
        }
        for (int col = 0; col < N; col++) {
            if (isValid(row, col)) { 
                queens[row] = col; 
                dfs(row + 1); 
            }
        }
    }
    static boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col) return false;
            if (Math.abs(queens[i] - col) == Math.abs(i - row)) return false;
        }
        return true; 
    }
    
    
}
