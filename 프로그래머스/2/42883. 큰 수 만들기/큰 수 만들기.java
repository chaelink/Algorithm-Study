import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder("");
        int n = number.length();
        Stack<Character> st = new Stack<>();
        
        int count = 0;
        st.push(number.charAt(0));
        
        for(int i=1; i<n; i++) {
            while(!st.isEmpty() && count<k && st.peek()<number.charAt(i)) {
                st.pop();
                count++;
            }
            st.push(number.charAt(i));
        }
        
        while(count<k) {
            st.pop();
            count++;
        }
        
        for(char c : st) {
            answer.append(c);
        }
        
        return answer.toString();
    }
}