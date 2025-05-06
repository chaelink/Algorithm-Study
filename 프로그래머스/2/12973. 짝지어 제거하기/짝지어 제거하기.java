import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Character> st = new Stack<>();
        
        st.push(s.charAt(0));
        for(int i=1; i<s.length(); i++) {
            char c = s.charAt(i);
            if(!st.isEmpty() && st.peek() == c) {
                st.pop();
            } else {
                st.push(c);
            }
        }
        if(st.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
}