import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length;
        int count = 0;
        int sum = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                for(int k=j+1; k<n; k++) {
                    if(sosu(nums[i] + nums[j] + nums[k])) {
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
    
//     public int dfs(int count, int sum, int[] nums) {
//         if(count==3) return sum;
//     }
    
    public boolean sosu(int a) {
        if(a<=1) return false;
        for(int b=2; b<a; b++) {
            if(a%b==0) return false;
        }
        return true;
    }
}