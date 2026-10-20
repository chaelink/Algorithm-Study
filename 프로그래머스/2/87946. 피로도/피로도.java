import java.util.*;
class Solution {
    int answer = 0;
    int[] visit;
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        visit = new int[n];
        
        dfs(k,dungeons, 0);
        
        return answer;
    }
    
    void dfs(int k, int[][] dungeons, int ans) {
        //갱신
        answer = Math.max(answer, ans);
        
        //탐색
        for(int i=0; i<dungeons.length; i++) {
            if(visit[i]==0 && dungeons[i][0]<=k) {
                visit[i] = 1;
                dfs(k-dungeons[i][1], dungeons, ans+1);
                visit[i] = 0;
            }
        }
    }
    
    
}