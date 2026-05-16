import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        //n-1개의 결과를 알면 순위 결정 가능
        
        boolean[][] game = new boolean[n][n];
        for(int[] r : results) {
            int win = r[0] - 1;
            int lose = r[1] - 1;
            game[win][lose] = true;
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                for(int k=0; k<n; k++) {
                    if(game[j][i] && game[i][k]) {
                        game[j][k] = true;
                    }
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            int check = 0;
            for(int j=0; j<n; j++) {
                if(game[i][j] || game[j][i]) {
                    check++;
                }
            }
            if(check == n-1) answer++;
        }
        
        return answer;
    }
}