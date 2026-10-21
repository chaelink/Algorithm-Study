import java.util.*;
class Solution {
    int[] visit;
    int n;
    List<String> ans = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        n = tickets.length;
        visit = new int[n];
        
        //icn을 시작으로 dfs
        dfs("ICN", tickets, "ICN",0);
        Collections.sort(ans);
        String[] answer = ans.get(0).split(" ");
        
        return answer;
    }
    
    void dfs(String dep, String[][] tickets, String list, int cnt) {
        //탈출, 모두 방문하면
        if(cnt==n) {
            ans.add(list);
            return;
        }
        
        //탐색
        for(int i=0; i<n; i++) {
            if(tickets[i][0].equals(dep) && visit[i]==0) {
                visit[i] = 1;
                dfs(tickets[i][1], tickets, list+" "+tickets[i][1], cnt+1);
                visit[i] = 0;
            }
        }
    }
}
