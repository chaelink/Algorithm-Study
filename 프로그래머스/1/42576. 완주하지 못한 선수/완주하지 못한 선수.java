import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String str : participant) {
            if(map.containsKey(str)) {
                map.put(str, map.get(str)+1);
            } else {
                map.put(str,1);
            }
        }
        
        for(String str : completion) {
            map.put(str, map.get(str)-1);
        }
        
        for(String name : map.keySet()) {
            if(map.get(name)!=0) {
                answer = name;
            }
        }
        
        return answer;
    }
}