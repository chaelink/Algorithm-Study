import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int[][] p = new int[n][4];
        
        //1행 값 설정
        for(int i=0; i<4; i++) {
            p[0][i] = land[0][i];
        }
        
        for(int i=1; i<n; i++) {
            for(int j=0; j<4; j++) {
                int ex=0;
                if(j==0) { ex= Math.max(Math.max(p[i-1][1], p[i-1][2]),p[i-1][3]);}
                if(j==1) { ex= Math.max(Math.max(p[i-1][0], p[i-1][2]),p[i-1][3]);}
                if(j==2) { ex= Math.max(Math.max(p[i-1][1], p[i-1][0]),p[i-1][3]);}
                if(j==3) { ex= Math.max(Math.max(p[i-1][1], p[i-1][2]),p[i-1][0]);}
                p[i][j] = ex + land[i][j]; 
            }
        }
        
        
        //완전탐색 - 백트래킹
        //아니면 그리디
        //dp?

        return Math.max(Math.max(p[n-1][0], p[n-1][1]),Math.max(p[n-1][2], p[n-1][3]));
    }
}