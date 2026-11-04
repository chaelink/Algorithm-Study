import java.util.*;
class Solution {
    List<String> list = new ArrayList<>();
    String[] str = {"aya", "ye", "woo", "ma"};
    List<String> now = new ArrayList<>();
    int[] visit = new int[4];
    
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(int i=0; i<4; i++) {
            list.add(str[i]);
        }
        
        //모든 순열 생성 -> n! 24번
        dfs(0,2);
        dfs(0,3);
        dfs(0,4);
        
        //리스트가 포함하는 지
        for(String s : babbling) {
            if(list.contains(s)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    void dfs(int cnt, int n) {
        if(cnt==n) {
            made();
            return;
        }
        
        for(int i=0; i<4; i++) {
            if(visit[i]==0) {
                visit[i] = 1;
                now.add(str[i]);
                dfs(cnt+1,n);
                now.remove(now.size()-1);
                visit[i] = 0;
            }
        }
    }
    
    void made() {
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<now.size(); i++) {
            sb.append(now.get(i));
        }
        list.add(sb.toString());
    }
}