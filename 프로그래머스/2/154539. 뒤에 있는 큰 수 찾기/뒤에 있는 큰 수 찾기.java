import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1); //-1로 채우기

        Stack<Integer> st = new Stack<>();
        
        for(int i= n-1; i>=0; i--) {
            while(!st.isEmpty() && numbers[st.peek()] <= numbers[i]) {
                st.pop();
            }
            if(!st.isEmpty()) {
                answer[i] = numbers[st.peek()];
            }
            st.push(i);
                
        }
        
        return answer;
    }
}