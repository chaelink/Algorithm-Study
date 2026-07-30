import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        //int ans;
        
        //난이도 diff 숙련도 level
        //숙련도에 따라 퍼즐을 풀 때 틀리는 횟수가 다름
        //제한시간 내에 퍼즐을 모두 해결하기 위한 숙련도의 최솟값
        //퍼즐은 최대 30만개
        int left = 1;
        int right = 0;
        for(int i : diffs) {
            right = Math.max(i,right);
        }
        
        while(left <= right) {
            int mid = (left + right)/2;
            long ans = 0;
            
            for(int i=0; i<diffs.length; i++) {
                if(diffs[i] > mid) {
                    ans += (diffs[i]-mid)*(times[i]+times[i-1]);
                    ans += times[i];
                } else {
                    ans += times[i];
                }
            }
            
            if(ans<= limit) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
             
        return left;
    }
}