import java.util.*;
class Solution {
    int wolf = 0;
    int sheep = 1;
    int n; int answer = 0;
    int[] visit;
    public int solution(int[] info, int[][] edges) {
        n = info.length;
        visit = new int[n];
        //늑대>=양 -> 모든 양이 잡아먹힘
        //잡아먹히지 X, 최대한 많은 수의 양 모으기 
        visit[0] = 1;
        dfs(0,1,info, edges);
        
        return answer;
    }
    void dfs(int wolf, int sheep, int[] info, int[][] edges) {
        //양 갯수 갱신
        answer = Math.max(answer, sheep);
        
        
        //탐색, [a,b] 일때 a를 이미 방문, b를 방문전
        for(int[] e : edges) {
            if(visit[e[0]]==1 && visit[e[1]]==0) {
                if(info[e[1]]==0) {
                    visit[e[1]]=1;
                    dfs(wolf, sheep+1, info, edges);
                    visit[e[1]]=0;
                } else {
                    if(wolf+1<sheep) {
                        visit[e[1]]=1;
                        dfs(wolf+1, sheep, info, edges);
                        visit[e[1]]=0; 
                    } 
                }
            }
        }
        //양 -> 진행
        
        //늑대 -> 추가해도 늑대<양이면 진행
    }
}