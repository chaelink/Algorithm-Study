import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int[] visited = new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i=0; i<n; i++) {
            if(visited[i]==0) {
                visited[i] = 1;
                q.add(i);
                answer++;
                while(!q.isEmpty()) {
                    int now = q.remove();
                    for(int j=0; j<n; j++) {
                        if(computers[now][j]==1 && visited[j]==0) {
                            q.add(j);
                            visited[j] = 1;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}