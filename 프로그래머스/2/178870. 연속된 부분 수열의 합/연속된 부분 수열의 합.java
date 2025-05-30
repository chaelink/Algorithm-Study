import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0,1000000};
        int n = sequence.length;
        
        int start = 0;
        int total = 0;
        
        for(int end=0; end<n; end++) {
            total += sequence[end];
            
            while(total>k) {
                total -= sequence[start];
                start++;
            }
            if(total == k) {
                if((end-start) < (answer[1] - answer[0]) ) {
                    answer[0] = start;
                    answer[1] = end;
                }
            }
        }
      
        return answer;
    }
}