import java.util.*;
class Solution {
    boolean solution(String s) {

        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(st.isEmpty()) {
                if(c == ')') return false;
                else st.push(1);
            } else {
                if(c == ')') st.pop();
                else st.push(1);
            }
            
        }
        if(!st.isEmpty()) return false;
    
        return true;
    }
}