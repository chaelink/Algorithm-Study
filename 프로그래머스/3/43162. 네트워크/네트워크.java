import java.util.*;

class Solution {
    int visited[];
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i=0; i<n; i++) {
            if(visited[i]==0) {
                q.add(i);
                
                while(!q.isEmpty()) {
                    int now = q.poll();
                    for(int j=0; j<n; j++) {
                        if(computers[now][j]==1 && visited[j]==0) {
                            q.add(j);
                            visited[j]=1;
                        }
                    }
                }
                answer++;
            }
        }
        return answer;
    }
}