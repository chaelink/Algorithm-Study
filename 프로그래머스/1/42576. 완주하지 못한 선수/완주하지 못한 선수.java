import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String,Integer> par = new HashMap<>();
        
        for(int i=0; i<participant.length; i++) {
            if(par.containsKey(participant[i])) {
                par.put(participant[i],par.get(participant[i])+1);
            } else {
               par.put(participant[i],1); 
            } 
        }
        for(int i=0; i<completion.length; i++) {
            if(par.containsKey(completion[i])) {
                par.put(completion[i],par.get(completion[i])-1);
            }
        }
        for (Map.Entry<String, Integer> entry : par.entrySet()) {
            if(entry.getValue()==1)
                answer = entry.getKey().toString();
        }
        return answer;
    }
}