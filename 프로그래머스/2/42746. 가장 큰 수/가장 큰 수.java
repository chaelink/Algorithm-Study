import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder("");
        int n = numbers.length;
        
        String[] str = new String[n];
        for(int i=0; i<n; i++) {
            str[i] = numbers[i]+"";
        }
        
        Arrays.sort(str, (a,b) -> (b+a).compareTo(a+b));
        
        if(str[0].equals("0")) {
            return "0";
        }
        
        for(int i=0; i<n; i++) {
            answer.append(str[i]);
        }
        
        return answer.toString();
    }
} 