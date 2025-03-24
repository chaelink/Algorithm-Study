import java.util.*;

class Solution {
    public long solution(long n) {
        long answer =0;
        String s = ""+n;
        long[] value = new long[s.length()];
        
        for(int i=0; i<s.length(); i++) {
            value[i] = n%10;
            n = n/10;
        }
        Arrays.sort(value);
        
        long ten = 1;
        
        for(int i=0; i<value.length; i++) {
            answer += value[i]*ten;
            ten = ten*10;
        }
        
        return answer;
    }
}