import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int)(right - left) +1;
        int[] answer = new int[size];
        
        int idx = 0;
        for(long i=left; i<=right; i++) {
            int j = (int)(i/n);
            int k = (int)(i%n);
            answer[idx] = Math.max(j,k)+1;
            idx++;
        }
        
        return answer;
    }
}