import java.util.*;
class Solution {
    List<List<Integer>> list = new ArrayList<>();
    int net=0;
    int[] visit;
    public int solution(int n, int[][] computers) {
        visit = new int[n];
        
        for(int i=0; i<n; i++) {
            list.add(new ArrayList<>());
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(computers[i][j]==1) {
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            if(visit[i]==0) {
                visit[i]=1;
                net++;
                dfs(i);
            }
        }
        
        return net;
    }
    
    void dfs(int c) {
        for(Integer i : list.get(c)) {
            if(visit[i]==0) {
                visit[i]=1;
                dfs(i);
            }
        }
    }
    
}