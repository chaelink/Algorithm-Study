import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        
        st.push(arr[0]);
        for(int i=1; i<arr.length; i++) {
            if(st.peek() != arr[i]) {
                ans.add(st.pop());
                st.push(arr[i]);
            } else {
                continue;
            }
        }
        
        if(!st.isEmpty()) {
            ans.add(st.pop());
        }
        
        int[] answer = new int[ans.size()];
        int idx = 0;
        for(Integer i : ans) {
            answer[idx] = i; idx++;
        }
        
        return answer;
    }
}