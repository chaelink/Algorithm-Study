import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        Map<Integer,Integer> set = new HashMap<>();
        for(int i=sum; i>0; i--) {
            if(sum%i==0) {
                int a = Math.max(i, sum/i);
                set.put(a, sum/a);
            }
        }
        
        for(Integer a : set.keySet()) {
            int b = set.get(a);
            if((a-2)*(b-2) == yellow) {
                answer[0] = a;
                answer[1] = b;
                return answer;
            }
        }
        
        
        
        return answer;
    }
}