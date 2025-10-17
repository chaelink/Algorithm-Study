import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int n = order.length;
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        
        for(int i=n; i>=1; i--) {
            st1.push(i);
        }
        
        for(int i=0; i<n; i++) {
            int a = order[i];
            
            while(!st1.isEmpty() && a>=st1.peek()) {
                int top = st1.pop();
                st2.push(top);
            }
                     
            if(!st2.isEmpty() && a==st2.peek()) {
                st2.pop();
                answer++;
            } else {
                return answer;
            }       
        }
        
        return answer;
    }
}