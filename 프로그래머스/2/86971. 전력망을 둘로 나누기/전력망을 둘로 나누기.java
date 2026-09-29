import java.util.*;
class Solution {
    int[] visit;
    int num1;
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        //arr 처리
        int[][] arr = new int[n+1][n+1];
        for(int[] w : wires) {
            int a = w[0];
            int b = w[1];
            arr[a][b] = 1; arr[b][a]=1;
        }
        
        //돌아가면서 길 하나 지우고
        for(int[] w : wires) {
            int a = w[0];
            int b = w[1];
            arr[a][b] = 0; arr[b][a]=0;
            //dfs로 갯수 카운트, 차 계산
            visit = new int[n+1];
            num1 = 0;
            dfs(1, n, arr);
            int num2 = n - num1;
            answer = Math.min(answer, Math.abs(num1-num2));
            arr[a][b] = 1; arr[b][a]=1;
        }   
        
        return answer;
    }
    
    void dfs(int idx, int n, int[][] arr) {
        visit[idx] = 1;
        num1++;
        
        for(int i=1; i<=n; i++) {
            if(arr[idx][i]==1 && visit[i]==0) {
                dfs(i,n,arr);
            }
        }
    }
    
}