import java.util.*;

class Solution {
    int answer = 0;
    int num = 0;
    String[] words = new String[]{"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        dfs("", word);
        
        return answer;
    }
    
    public void dfs(String now, String word) {
        if(now.equals(word)) {
            answer = num;
            return;
        }
        num++;

        if(now.length()==5) return;
        
        for(int i=0; i<5; i++) {
            dfs(now + words[i], word);
            
        }
        
    }
}