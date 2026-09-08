import java.util.*;
class Solution
{
    public int solution(String s)
    {
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        for(int i=1; i<s.length(); i++) {
            if(st.size()>0 && st.peek() == s.charAt(i)) {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }
        
        if(st.size()>0) {return 0;}
        else return 1;
      
    }
}