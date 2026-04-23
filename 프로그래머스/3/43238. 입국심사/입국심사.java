import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left = 0;
        long right = times[times.length-1]* (long)n;
        while(left <= right) {
            long mid = (right + left)/2;
            long count = 0;
            for(int i : times) {
                count += (mid/i);
            }
            if(count>=n) {
                answer = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        //answer = mid;
        
        return answer;
    }
}