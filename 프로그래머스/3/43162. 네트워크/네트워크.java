import java.util.*;

class Solution {
    int[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new int[n];
        
        for(int i=0; i<n; i++) {
            if(visited[i]==0) {
                visited[i]=1;
                dfs(computers, i);
                answer++;
            }
        }
        return answer;
    }
    
    void dfs(int[][] computers, int k) {
        int n = computers.length;
        for(int i=0; i<n; i++) {
            if(computers[k][i]==1 && visited[i]==0) {
                visited[i]=1;
                dfs(computers,i);
            }
        }
    }
}