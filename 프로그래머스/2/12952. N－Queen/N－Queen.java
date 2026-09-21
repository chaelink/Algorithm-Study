import java.util.*;
class Solution {
    int answer = 0;
    public int solution(int n) {
        //퀸 이동 규칙
        //가로, 세로, 대각선 방향으로 이동 가능
        //백트래킹
        int[][] arr = new int[n][n];
        //행에 하나
        // 열, 대각선에 하나
        
        dfs(0, n, arr);
        
        
        return answer;
    }
    
    void dfs(int count, int n, int[][] arr) {
        //count 가 n이면 answer 증가, return(끝)
        if(count==n) {
            answer++;
            //System.out.println(answer);
            return;
        }
        
        //아직 n개가 아님, 배치
        for(int i=0; i<n; i++) {
            //같은 열에 존재하는가
            boolean same = false;
            for(int j=0; j<count; j++) {
                if(arr[j][i]==1) {same=true; break;}
            }
            if(same) continue;
            
            //대각선, 왼쪽
            int j = count-1;
            int k = i-1;
            while(j>=0 && k>=0) {
                if(arr[j][k]==1) {same = true; break;}
                j--;
                k--;
            }
            if(same) continue;
            
            //대각선, 오른쪽
            j = count-1;
            k = i+1;
            while(j>=0 && k<n) {
                if(arr[j][k]==1) {same = true; break;}
                j--;
                k++;
            }
            if(same) continue;
            
            //가능
            arr[count][i] = 1;
            //System.out.println(count+ " + "+ i);
            //다음 재귀
            dfs(count+1, n, arr);
            arr[count][i]=0;
        }
        
    }
}