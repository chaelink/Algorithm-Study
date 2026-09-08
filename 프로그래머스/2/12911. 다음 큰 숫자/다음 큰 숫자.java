import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        String bi = Integer.toString(n,2);
        int count = 0;
        for(int i=0; i<bi.length(); i++) {
            if(bi.charAt(i)=='1') count++;
        }
        
        while(true) {
            n++;
            String bin = Integer.toString(n, 2);
            int count2 = 0;
            for(int i=0; i<bin.length(); i++) {
                if(bin.charAt(i)=='1') count2++;
            }
            if(count == count2) {
                return n;
            }
        }
      
    }
}