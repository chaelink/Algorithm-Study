import java.util.*;

class Solution {
    public String solution(String phone_number) {
        StringBuilder answer = new StringBuilder();
        
        int n = phone_number.length();
        for(int i=0; i<n-4; i++) {
            answer.append("*");
        }
        for(int i=n-4; i<n; i++) {
            answer.append(phone_number.charAt(i));
        }
        return answer.toString();
    }
}