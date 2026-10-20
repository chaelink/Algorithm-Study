import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int n = targets.length;
        Arrays.sort(targets, (a,b) -> b[1] - a[1]);
        
        int idx = 0;
        int start = 0;
        int end = 0;
        while(idx<n) {
            start = targets[idx][0];
            
            int cnt = 0;
            for(int i=idx+1; i<n; i++) {
                if(start<targets[i][1]) {
                    cnt++;
                    start = Math.max(start, targets[i][0]);
                } else {break;}
            }
            
            idx += (cnt+1);
            answer++;
        }
        
        return answer;
    }
}