import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();
        if(check(s)) answer++;
        
        for(int i=1; i<n; i++) {
            char c = s.charAt(0);
            s = s.substring(1);
            s += c;
            if(check(s)) answer++;
        }
        //for문 돌면서 s 새로 만들고 -> 확인
  
        return answer;
    }
    
    boolean check(String str) {
        Stack<Character>st = new Stack<>();
        
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(c=='(') {
                st.push(')');
            } else if(c=='['){
                st.push(']');
            } else if(c=='{'){
                st.push('}');
            }else {
                if(st.isEmpty()) {return false;}
                else {
                    char top = st.pop();
                    if(top != c) return false;
                }
            }
        }
        if(st.size()==0) {
            return true;
        }
        return false;
    }
}