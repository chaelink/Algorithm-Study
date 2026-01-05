import java.util.*;

class Solution {
    int[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int n2 = computers.length;
        visited = new int[n2];
        
        for(int i=0; i<n2; i++) {
            if(visited[i]==0) {
                dfs(i, computers, n2);
                answer++;
            }
        }
        return answer;
    }
    void dfs(int idx, int[][] computers, int n2) {
        visited[idx] = 1;
        for(int i=0; i<n2; i++) {
            if(computers[idx][i]==1 && visited[i]==0) {
                dfs(i, computers, n2);
            }
        }
    }
}