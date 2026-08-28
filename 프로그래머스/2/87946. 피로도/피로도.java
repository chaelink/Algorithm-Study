import java.util.*;
class Solution {
    int[] visit;
    int answer = 0;
    int n;
    public int solution(int k, int[][] dungeons) {
        
        //최소필요, 소모
        n = dungeons.length;
        visit = new int[n];
        
        dfs(k, dungeons, 0);
        
        return answer;
    }
    
    void dfs(int k, int[][] dungeons, int d) {
        answer = Math.max(answer, d);
        
        for(int i=0; i<n; i++) {
            if(visit[i]==0 && dungeons[i][0]<=k) {
                visit[i]=1;
                dfs(k-dungeons[i][1], dungeons, d+1);
                visit[i] = 0;
            }
        }
    }
}