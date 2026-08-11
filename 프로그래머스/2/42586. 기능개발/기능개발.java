import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int n = progresses.length;
        int done = 0;
        
        while(done != n) {
            int t = (100 - progresses[done]) / speeds[done];
            if((100 - progresses[done]) % speeds[done]>0) t++;
            st.push(100);
            
            for(int i=done+1; i<n; i++) {
                progresses[i] += speeds[i]*t;
            }
            
            for(int i=done+1; i<n; i++) {
                if(progresses[i]>=100) st.push(1);
                else {break;}
            }
            
            int num = st.size();
            //System.out.println(num);
            list.add(num);
            done += num;
            st.clear();
        }
        
        int[] answer = new int[list.size()];
        int idx = 0;
        for(Integer i : list) {
            answer[idx] = i;
            idx++;
        }
        
        return answer;
    }
}