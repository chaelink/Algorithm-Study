import java.util.*;
class Solution {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase();
        
        answer = answer.replaceAll("[^a-z0-9-_.]","");
        
        answer = answer.replaceAll("\\.{2,}",".");
        
        answer = answer.replaceAll("^\\.|\\.$","");
        
        if(answer.length()==0) {
            answer = "a";
        } else if(answer.length()>=16) {
            answer = answer.substring(0,15);
            if(answer.charAt(14)=='.') {
                answer = answer.substring(0,14);
            }
        }
        
        while(answer.length()<=2) {
            char c = answer.charAt(answer.length()-1);
            answer = answer + c;
        }
        
        
        return answer;
    }
}