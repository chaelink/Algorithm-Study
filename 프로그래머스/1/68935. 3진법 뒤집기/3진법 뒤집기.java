import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        
        while(n!=0) {
            list.add(n%3);
            n = n/3;
        }
        
        int c = list.size()-1;
        
        for(int i=c; i>=0; i--) {
            answer += (Math.pow(3,c-i)*list.get(i));
        }
        
        return answer;
    }
}