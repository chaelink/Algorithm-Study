import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int n = brown + yellow;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=n; i>=1; i--) {
            if(n%i == 0 && i>=n/i) {
                map.put(i,n/i);
            }
        }
        
        for(Integer i : map.keySet()) {
            int x = i;
            int y = map.get(i);
            
            if((2*x + 2*y -4) == (brown)) {
                answer[0] = x;
                answer[1] = y;
               
            }
        }
        return answer;
    }
}