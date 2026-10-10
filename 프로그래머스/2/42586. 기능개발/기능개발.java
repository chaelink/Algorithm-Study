import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        int n = speeds.length;
        Stack<Integer> st = new Stack<>();
        
        int idx = 0;
        
        while(idx<n) {
            
            while(progresses[idx]<100) {
                for(int i = idx; i<n; i++) {
                    progresses[i] += speeds[i];
                }
            }
            
            for(int i = idx; i<n; i++) {
                if(progresses[i]>=100) {
                    st.push(1);
                } else {break;}
            }
            
            list.add(st.size());
            idx += st.size();
            st.clear();
            
        }
    
        int[] answer = new int[list.size()];
        int d = 0;
        for(Integer num : list) {
            answer[d] = num;
            d++;
        }
        
        
        return answer;
    }
}