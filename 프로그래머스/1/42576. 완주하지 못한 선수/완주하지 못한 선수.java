import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        int n = participant.length;
        
        for(int i=0; i<n; i++) {
            map.put(participant[i],map.getOrDefault(participant[i],0)+1);
        }
        
        int m = completion.length;
        
        for(int i=0; i<m; i++) {
            map.put(completion[i], map.getOrDefault(completion[i],0)-1);
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                answer = entry.getKey();
            }
        }
        return answer;
    }
}