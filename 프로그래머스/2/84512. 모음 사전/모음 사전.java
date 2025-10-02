import java.util.*;

class Solution {
    int answer = 0;
    HashMap<String, Integer> map = new HashMap<>();
    String[] words = new String[]{"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        dfs("");
        return map.get(word);
    }
    
    public void dfs(String now) {
        map.put(now, answer);
        answer++;
        
        if(now.length()==5) return;
        
        for(int i=0; i<5; i++) {
            dfs(now + words[i]);
            
        }
        
    }
}