import java.util.*;
class Solution {
    List<List<Integer>> list = new ArrayList<>();
    int[] visit; 
    int[] ans = new int[2];
    int answer = 0;
    int n;
    public int solution(int[] info, int[][] edges) {
        n = info.length;
        
        for(int i=0; i<n; i++) {
            list.add(new ArrayList<>());
        }
        for(int[] e : edges) {
            int a = e[0]; int b = e[1];
            list.get(a).add(b);
        }
        visit = new int[n];
        ans[0] = 1;
        visit[0] = 1;
        
        dfs(0, info);
        
        return answer;
    }
    
    void dfs(int node, int[] info) {
        if(ans[0]<=ans[1]) {
            return;
        }
        
        answer = Math.max(answer, ans[0]);
        
        //선택지
        for(int i=0; i<n; i++) {
            for(Integer idx : list.get(i)) {
                if(visit[i]==1 && visit[idx]==0) {
                    ans[info[idx]]++;
                    visit[idx]=1;
                    dfs(idx, info);
                    ans[info[idx]]--;
                    visit[idx]=0;
                }
            }
        }
    }
}