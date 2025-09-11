import java.util.*;

class Solution {
    int visited[];
    List<String> answer = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        int n = tickets.length;
        visited = new int[n];
       
        String path = "";
        
        dfs(0, n, "ICN", tickets, "ICN");
        
        Collections.sort(answer);
        
        return answer.get(0).split(" ");
    }
    
    public void dfs(int depth, int n, String start, String[][] tickets, String path) {
        if(depth == n) {
            answer.add(path);
            return;
        }
        for(int i=0; i<n; i++) {
            if(tickets[i][0].equals(start) && visited[i]==0) {
                visited[i] = 1;
                dfs(depth+1, n, tickets[i][1], tickets, path + " " + tickets[i][1]);
                visited[i] = 0;
            }
        }
    }
}