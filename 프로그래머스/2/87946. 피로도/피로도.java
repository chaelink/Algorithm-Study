import java.util.*;

class Solution {
    int count = 0;
    int n;
    int[] visited;
    
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        visited = new int[n];
        
        dfs(dungeons, k, 0);
        return count;
    }
    
    public void dfs(int[][] dungeons, int k, int c) {
        count = Math.max(count, c);
        
        for(int i=0; i<n; i++) {
            if(visited[i]==0 && k>= dungeons[i][0]) {
                visited[i] = 1;
                k -= dungeons[i][1];
                dfs(dungeons, k, c+1);
                k += dungeons[i][1];
                visited[i] = 0;
            }
        }
    }
}