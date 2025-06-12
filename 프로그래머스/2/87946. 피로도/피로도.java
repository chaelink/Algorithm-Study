import java.util.*;

class Solution {
    int answer = 0;
    int[] visited;
    int n;
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        visited = new int[n];
        
        for(int i=0; i<n; i++) {
            dfs(i,k,1,dungeons);
            if(answer == n) {
                return answer;
            }
        }
        if(answer == 0) {
            return -1;}
        
        return answer;
    }
    
    void dfs(int idx, int k, int d, int[][] dungeons) {
        visited[idx] = 1;
        answer = Math.max(answer, d);
        k -= dungeons[idx][1];
        for(int i=0; i<n; i++) {
            if(visited[i]==0 && dungeons[i][0]<=k) {
                dfs(i, k, d+1,dungeons);
                visited[i]=0; 
            }
        }
        visited[idx] = 0;
    }
}