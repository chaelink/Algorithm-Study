import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> name = new HashMap<>();
        for(String s : participant) {
            name.put(s, name.getOrDefault(s,0)+1);
        }
        
        for(String s : completion) {
            name.put(s, name.get(s)-1);
        }
        
        for(String s : name.keySet()) {
            if(name.get(s)==1) {
                answer = s;
                break;
            }
        }
        
        return answer;
    }
}