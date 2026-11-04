import java.util.*;
class Solution{
    public int solution(String s) {
        Stack<Character>st = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            //스택이 비어있지 않으면 짝지어 제거 가능한지 확인
            if(!st.isEmpty()) {
                char top = st.peek();
                if(top==c) {
                    st.pop();
                } else {
                    st.push(c);
                }
            } else {
                //스택이 비어있으면 그냥 삽입
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