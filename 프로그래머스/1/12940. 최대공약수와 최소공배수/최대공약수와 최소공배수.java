import java.util.*;
class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = gcd(n,m);
        answer[1] = lcm(n,m);
        
        return answer;
    }
    
    int gcd(int n, int m) {
        if(m==0) return n;
        return gcd(m, n%m);
    }
    
    int lcm(int n, int m) {
        return (n/gcd(n,m))*m ;
    }
}