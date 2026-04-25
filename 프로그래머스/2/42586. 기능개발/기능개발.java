import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> ans = new ArrayList<>();
        int idx = 0;
        int n = speeds.length;
        while(idx < n) {
            if(progresses[idx]>=100) {
                Deque<Integer> q = new ArrayDeque<>();
                for(int i=idx; i<n; i++) {
                    if(progresses[i]>=100) q.add(i);
                    else break;
                }
                ans.add(q.size());
                idx += q.size();
            }
            
            for(int i=idx; i<n; i++) {
                progresses[i] += speeds[i];
            }
        }
        
        int[] answer = new int[ans.size()];
        for(int i=0; i<ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        
        
        return answer;
    }
}