import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        List<Integer> ans = new LinkedList<>();
        
        for(int i=0; i<arr.length; i++) {
            if(arr[i]%divisor == 0) {
                ans.add(arr[i]);
            }
        }
        
        if(ans.isEmpty()) {
            int[] answer = {-1};
            return answer;
        }
        
        Collections.sort(ans);
        int[] answer = new int[ans.size()];
        int idx=0;
        for(Integer i : ans) {
            answer[idx] = i;
            idx++;
        }
        return answer;
    }
}