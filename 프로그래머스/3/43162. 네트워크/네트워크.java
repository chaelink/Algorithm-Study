import java.util.*;

class Solution {
    //컴퓨터 방문 체크 
    int[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new int[n];
        
        // 컴퓨터 n 0부터 for문으로 체크
        for(int i=0; i<n; i++) {
            if(visited[i]==0) {
                //아직 방문 전이면 dfs 돌기
                dfs(i, n, computers);
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(int k, int n, int[][] computers) {
        visited[k] = 1;
        
        for(int i=0; i<n; i++) {
            if(computers[k][i]==1 && visited[i]==0) {
                dfs(i, n, computers);
            }
        }
    }
    
}