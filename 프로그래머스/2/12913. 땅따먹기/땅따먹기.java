import java.util.*;
class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int[][] arr = new int[n][4];
        //각 열 별 누적합
        
        for(int i=0; i<4; i++) {
            arr[0][i] = land[0][i];
        }
        
        for(int i=1; i<n; i++) {
            for(int j=0; j<4; j++) {
                int max = 0;
                for(int k=0; k<4; k++) {
                    if(k!=j) {
                        max = Math.max(max,arr[i-1][k]);
                    }
                }
                arr[i][j] = max + land[i][j];
            }
        }
        
        for(int i=0; i<4; i++) {
            answer = Math.max(answer, arr[n-1][i]);
        }
        
        return answer;
    }
}