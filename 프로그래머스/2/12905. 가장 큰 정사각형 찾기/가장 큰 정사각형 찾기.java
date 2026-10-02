import java.util.*;
class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] arr = new int[n][m];
        
        for(int i=0; i<m; i++) {
            arr[0][i] = board[0][i];
        }
        for(int i=0; i<n; i++) {
            arr[i][0] = board[i][0];
        }
        
        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                if(board[i][j]==1) {
                    arr[i][j] = Math.min(Math.min(arr[i-1][j], arr[i][j-1]),arr[i-1][j-1])+1;
                } else {
                    arr[i][j] = 0;
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                answer = Math.max(answer, arr[i][j]);
            }
        }
        
        return answer*answer;
    }
}