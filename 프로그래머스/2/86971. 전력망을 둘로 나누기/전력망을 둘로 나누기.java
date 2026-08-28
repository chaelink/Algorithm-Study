import java.util.*;
class Solution {
    int answer = Integer.MAX_VALUE;
    int[][] arr;
    int[] visit;
    int count = 1;
    
    public int solution(int n, int[][] wires) {
        //arr 작성
        arr = new int[n+1][n+1];
        for(int[] w : wires) {
            int a = w[0];
            int b = w[1];
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        
        for(int[] w : wires) {
            int a = w[0];
            int b = w[1];
            arr[a][b] = 0;
            arr[b][a] = 0;
            visit = new int[n+1];
            int idx=0;
            int[] min = new int[2];
            for(int i=1; i<=n; i++) {
                if(visit[i]==0) {
                    visit[i] =1;
                    dfs(n,i);
                    min[idx]= count;
                    count=1; idx++; 
                }
            }
            answer = Math.min(answer, Math.abs(min[0]-min[1]));
            arr[a][b] = 1;
            arr[b][a] = 1;
            
        }
        
        
        return answer;
    }
    
    void dfs(int n, int k) {
        
        for(int i=1; i<=n; i++) {
            if(visit[i]==0 && arr[i][k]==1) {
                visit[i] = 1;
                count++;
                dfs(n,i);
            }
        }
    }
    
}