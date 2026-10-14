import java.util.*;
class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        int n = d/k;
        for(int i=0; i<=n; i++) {
            long x = (long)i*k;
            double y = Math.sqrt((long)d*d - x*x);
            answer +=(long)(y/k+1);
        }
        
        return answer;
    }
}