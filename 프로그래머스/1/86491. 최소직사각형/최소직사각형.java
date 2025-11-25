import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        //각 명함 별 가로 or 세로
        //1만
        //dp?
 
        int a = 0; int b = 0;
        for(int i=0; i<sizes.length; i++) {
            if(sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
            a = Math.max(a, sizes[i][0]);
            b = Math.max(b, sizes[i][1]);
        }
        
        return a*b;
    }
}