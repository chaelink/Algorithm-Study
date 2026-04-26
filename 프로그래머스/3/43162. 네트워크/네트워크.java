import java.util.*;
class Solution {
    int[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new int[n];
        
        for(int i=0; i<n; i++) {
            if(visited[i]==0) {
                answer++;
                dfs(i, computers);
            }
        }
        
        return answer;
    }
    
    void dfs(int idx, int[][] computers) {
        for(int i=0; i<computers.length; i++) {
            if(computers[i][idx]==1 && visited[i]==0) {
                visited[i] = 1;
                dfs(i,computers);
            }
        }
    }
}