import java.util.*;
class Solution {
    public int solution(int[][] signals) {
        int answer = -1;
        int n = signals.length;
        int[] cycle = new int[n];
        for(int i=0; i<n; i++) {
            int[] now = signals[i];
            int num = 0;
            for(int j=0; j<3; j++) {
                num += now[j];
            }
            cycle[i] = num;
        }
        
        int maxnum = cycle[0];
        
        for(int i=1; i<n; i++) {
            maxnum = lcm(maxnum, cycle[i]);
        }
        
        int idx = 0;
        
        while(idx <= maxnum) {
            int count=0;
            for(int i=0; i<n; i++) {
                int t = idx%cycle[i];
                if(t>= signals[i][0]+1 && t<=signals[i][0]+signals[i][1]) {
                    count++;
                }
            }
            if(count==n) {
                return idx;
            }
            idx++;
        }
        
        return -1;
    }
    
    int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b,a%b);
    }
    
    int lcm(int a, int b) {
        return a/gcd(a,b)*b;
    }
}