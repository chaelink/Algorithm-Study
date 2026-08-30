import java.util.*;
class Solution {
    int[][] arr;
    int[] visit;
    int count=0;
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        //arr에 연결 저장
        arr = new int[n+1][n+1];
        for(int[] w : wires) {
            int a = w[0]; int b = w[1];
            arr[a][b] = 1; arr[b][a] = 1;
        }
        
        
        //와이어 하나씩 끊어가면서
        //1번부터 n번까지 순회
        for(int[] w : wires) {
            int a = w[0]; int b = w[1];
            arr[a][b] = 0; arr[b][a] = 0;
            
            visit = new int[n+1];
            count =0;
            for(int i=1; i<=n; i++) {
                if(visit[i]==0) {
                    visit[i]=1;
                    count++;
                    dfs(i,n);
                    int cha = Math.abs(n - 2*count);
                    answer = Math.min(answer, cha);
                    break;
                }
            }
            
            arr[a][b] = 1; arr[b][a] = 1;
        }
        
        return answer;
    }
    
    void dfs(int k, int n) {
        
        for(int i=1; i<=n; i++) {
            if(visit[i]==0 && arr[k][i]==1) {
                visit[i]=1;
                count++;
                dfs(i,n);
            }
        }
    }
    
}