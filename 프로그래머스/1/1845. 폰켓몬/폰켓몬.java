import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        // 3 3 
        // 2 3
        // 3개
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        
        for(int i : nums) {
            map.put(i, map.getOrDefault(i,0)+1);
        }
        
        if(map.size()>= n/2) {
            return n/2;
        } else {
            return map.size();
        }
        
    }
}