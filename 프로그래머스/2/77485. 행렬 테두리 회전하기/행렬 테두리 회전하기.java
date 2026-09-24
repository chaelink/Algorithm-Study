import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr = new int[rows+1][columns+1];
        //최초 숫자 넣어주기
        for(int i=1; i<rows+1; i++) {
            for(int j=1; j<columns+1; j++) {
                arr[i][j] = ((i-1)*columns+j);
            }
        }   
        
        int idx=0;
        for(int[] q : queries) {
            int minn = Integer.MAX_VALUE;
            int x1 = q[0];
            int y1 = q[1];
            int x2 = q[2];
            int y2 = q[3];
            int now = 0;
            int before = arr[x1][y1];
            //y1 부터 y2
            for(int i=y1; i<=y2; i++) {
                now = arr[x1][i];
                minn = Math.min(minn,now);
                arr[x1][i] = before;
                before = now;
            }
            //x1 x2
            for(int i=x1+1; i<=x2; i++) {
                now = arr[i][y2];
                minn = Math.min(minn,now);
                arr[i][y2] = before;
                before = now;
            }
            //y2 y1
            for(int i=y2-1; i>=y1; i--) {
                now = arr[x2][i];
                minn = Math.min(minn,now);
                arr[x2][i] = before;
                before = now;
            } 
            //x2 x1
            for(int i=x2-1; i>=x1; i--) {
                now = arr[i][y1];
                minn = Math.min(minn,now);
                arr[i][y1] = before;
                before = now;
            }
            answer[idx] = minn;
            
            idx++;
        }   
        
        return answer;
    }
}