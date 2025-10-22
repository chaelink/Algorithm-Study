import java.util.*;

class Solution {
    public String solution(String number, int k) {
        //인접비교만으로도 최적해 보장 -> 접두 최적성을 가지기 때문
        StringBuilder answer = new StringBuilder();
        
        Stack<Character> st = new Stack<>();
        
        for(char c : number.toCharArray()) {
            while(k>0 && !st.isEmpty() && st.peek()<c ) {
                st.pop();
                
                k--;
            }
            st.push(c);
        }
        
        while(k>0) {
            st.pop();
            k--;
        }
        
        for(char c : st) {
            answer.append(c);
        }
        
        return answer.toString();
    }
}