import java.util.*;
class Solution {
    int answer = 0;
    int[] visit;
    public int solution(int k, int[][] dungeons) {
        
        //던전이 8개 이하다 -> 2의n제곱 시간 복잡도인 완전탐색이 가능하다
        visit = new int[dungeons.length];
        for(int i=0; i<dungeons.length; i++) {
            if(k>=dungeons[i][0]) {
                visit[i]=1;
                k -= dungeons[i][1];
                dfs(k,1,dungeons);
                k += dungeons[i][1];
                visit[i] = 0; 
            }
        }
        
        return answer;
    }
    
    void dfs(int k, int n, int[][] dungeons) {
        answer = Math.max(answer, n);
        
        for(int i=0; i<dungeons.length; i++) {
            if(visit[i]==0 && k>=dungeons[i][0]) {
                visit[i]=1;
                k -= dungeons[i][1];
                dfs(k,n+1, dungeons);
                k += dungeons[i][1];
                visit[i] = 0;
            }
        }
    }
}