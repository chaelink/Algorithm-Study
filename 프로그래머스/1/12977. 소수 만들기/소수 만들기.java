import java.util.*;

class Solution {
    public int solution(int[] nums) {
        //주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수
        int answer = 0;
        int n = nums.length;
        int sum = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                for(int k=j+1; k<n; k++) {
                    sum = nums[i] + nums[j] + nums[k];
                    if(sosu(sum)) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
    
    boolean sosu(int a) {
        for(int i=2; i<a; i++) {
            if(a%i==0) {
                return false;
            }
        }
        return true;
    }
}