import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int v = (int)(right - left) +1;
        int[] answer = new int[v];
        int idx = 0;
        for(long i=left; i<=right; i++) {
            int m = Math.max((int)(i/n), (int)(i%n));
            answer[idx] = (m+1);
            idx++;
        }
        
        return answer;
    }
}