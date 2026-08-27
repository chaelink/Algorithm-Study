import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        //가로x , 세로 y
        
        int sum = brown + yellow;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=1; i<sum/2; i++) {
            if(sum%i==0) {
                int x = Math.max(i, sum/i);
                int y = sum / x;
                map.put(x,y);
            }
        }
        for(Integer x : map.keySet()) {
            int y = map.get(x);
            if(2*x + 2*y == (brown+4)){
                answer[0] = x;
                answer[1] = y;
                break;
            }
        }
        
        return answer;
    }
}