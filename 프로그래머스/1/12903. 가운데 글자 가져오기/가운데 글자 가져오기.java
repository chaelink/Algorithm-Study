import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int n = s.length();
        if(s.length()%2==0) {
            answer.append(s.charAt(n/2-1));
            answer.append(s.charAt(n/2));
        } else {
            answer.append(s.charAt(n/2));
        }
        return answer.toString();
    }
}