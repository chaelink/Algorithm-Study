import java.util.*;

class Solution {
    int answer = 0;
    StringBuilder s = new StringBuilder("");
    String[] str = {"A", "E", "I", "O", "U"};
    int num = 0;
    
    public int solution(String word) {
        dfs(s, word);
        
        return answer;
    }
    
    public void dfs(StringBuilder s, String word) {
        if(s.toString()==word) {
            answer = num;
            return;
        }
        num++;
        if(s.length()==5) {
            return;
        }
        
        for(int i=0; i<5; i++) {
            s.append(str[i]);
            dfs(s, word);
            s.deleteCharAt(s.length()-1);
        }
        
    }
    
}