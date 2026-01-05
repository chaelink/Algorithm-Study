import java.util.*;


class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        //인덱스를 스택으로
        Stack<Integer> st = new Stack<>();
        
        //처음부터 순회하면서 작으면 바로 결과 처리
        for(int i=0; i<n; i++) {
            while(!st.isEmpty()) {
                if(prices[st.peek()] > prices[i]) {
                    int j = st.pop();
                    answer[j] = i-j;
                } else {
                    break;
                }
            }
            st.push(i);
        }
        
        //끝까지 다 순회한 후 남은 값 처리
        while(!st.isEmpty()) {
            int index = st.pop();
            answer[index] = n-1 - index;
        }
        return answer;
    }
}