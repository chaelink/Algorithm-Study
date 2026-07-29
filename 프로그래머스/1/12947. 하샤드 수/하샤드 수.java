import java.util.*;

class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        String[] str = String.valueOf(x).split("");
        
        long sum = 0;
        for(int i=0; i<str.length; i++) {
            sum += Long.parseLong(str[i]);
        }
        
        if(x%sum==0) {
            answer = true;
        } else {
            answer = false;
        }
        
        return answer;
    }
}