import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        int n = progresses.length;
        int idx = 0;
        Stack<Integer> st = new Stack<>();
        
        while(idx<n) {
            if(!st.isEmpty()) {
                list.add(st.size());
                idx += st.size();
                st = new Stack<>();
            }
            if(idx==n) break;
            
            for(int i=idx; i<n; i++) {
                progresses[i] += speeds[i];
            }
            
            if(progresses[idx]>=100) {
                for(int i=idx; i<n; i++) {
                    if(progresses[i]>=100) {
                        st.push(i);
                    } else {break;}
                }
            }
        }
        
        int[] answer = new int[list.size()];
        int i=0;
        for(Integer in : list) {
            answer[i] = in;
            i++;
        }
            
        return answer;
    }
}