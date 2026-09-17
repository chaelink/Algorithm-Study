import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        //연속된 수들의 합
        int l = 1;
        int r = 1;
        int sum = 1;
        
        while(l<=r && r<=n) {
            if(sum == n) {
                answer++;
                r++;
                sum += r;
            } else if(sum < n) {
                r++;
                sum += r;
            } else {
                sum -= l;
                l++;
            }
        }
        
        return answer;
    }
}