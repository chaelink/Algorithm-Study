import java.util.*;
class Solution {
    int answer = 0;
    public int solution(int n) {
        
        //int[][] arr = new int[n][n];
        int[] arr = new int[n];
        //arr[0] 0번 행 퀸의 위치
        
        dfs(0, n, arr);
        
        return answer;
    }
    
    void dfs(int count, int n, int[] arr) {
        //탈출 조건
        if(count==n) {
            answer++;
            return;
        }
        
        //선택지
        for(int i=0; i<n; i++) {
            //같은 열에 존재하는가
            boolean same = false;
            
            for(int j=0; j<count; j++) {
                if(arr[j]==i) {same=true; break;}
            }
            if(same) continue;
            
            //대각선
            for(int j=0; j<count; j++) {
                if(Math.abs(count-j) == Math.abs(i-arr[j])) {
                    same = true;
                    break;
                }
            }
            
            if(same) continue;
            
            //가능
            arr[count] = i;
            dfs(count+1, n, arr);
        }
    }
}