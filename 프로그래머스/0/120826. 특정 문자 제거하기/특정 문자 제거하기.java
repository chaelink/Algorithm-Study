import java.util.*;

class Solution {
    public String solution(String my_string, String letter) {
        StringBuilder answer = new StringBuilder("");
        String[] s = my_string.split("");
        
        for(int i=0; i<s.length; i++) {
            if(!s[i].equals(letter)) {
                answer.append(s[i]);
            } 
        }
        return answer.toString();
    }
}