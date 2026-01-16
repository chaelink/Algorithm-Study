import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
      
        int n = 0;
        int m = 0;
    
        for(int idx=0; idx<goal.length; idx++) {
            if(n<cards1.length&&goal[idx].equals(cards1[n])) {
                n++;
            } else if(m<cards2.length&&goal[idx].equals(cards2[m])) {
                m++;
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}