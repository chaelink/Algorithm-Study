import java.util.*;
class Solution {
    int n;
    int[] visit;
    int answer=0;
    public int solution(int k, int[][] dungeons) {
        
        //던전이 8개
        n = dungeons.length;
        visit = new int[n];
        
        
        dfs(k, dungeons, 0);
        
        
        return answer;
    }
    
    void dfs(int k, int[][] dungeons, int count) {
        answer = Math.max(answer, count);
        
        for(int i=0; i<n; i++) {
            if(visit[i]==0 && k >= dungeons[i][0]) {
                visit[i] = 1;
                dfs(k-dungeons[i][1], dungeons, count+1);
                visit[i] = 0;
            }
        }
    }
}