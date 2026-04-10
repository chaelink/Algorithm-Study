import java.util.*;

class Solution {
    public int solution(int[] num_list) {
       
        int n = num_list.length;
        int x=1;
        int s=0;
        for(int i=0; i<n; i++) {
            x = x*num_list[i];
            s = s+num_list[i];
        }
        if(x < Math.pow(s,2)) {
            return 1;
        } else {
            return 0;
        }
    }
}