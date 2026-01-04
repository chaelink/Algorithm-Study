import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        int n = participant.length;
        int m = completion.length;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<n; i++) {
            map.put(participant[i], map.getOrDefault(participant[i],0)+1);
        }
        for(int i=0; i<m; i++) {
            int num = map.get(completion[i]);
            //System.out.println(completion[i] + " " + num);
            map.put(completion[i], num -1);
        }
        
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue()==1) {
                answer = entry.getKey();
            }
        }
        
        return answer;
    }
}