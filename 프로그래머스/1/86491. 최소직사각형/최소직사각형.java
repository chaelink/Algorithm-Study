import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        List<Integer> min = new ArrayList<>();
        List<Integer> max2 = new ArrayList<>();
        
        for(int[] s : sizes) {
            Arrays.sort(s);
            min.add(s[0]);
            max2.add(s[1]);
        }
        
        answer = Collections.max(min) * Collections.max(max2);
        
        return answer;
    }
}