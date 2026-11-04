import java.util.*;
class Solution {
    public int solution(int a, int b) {
        int n = gcd(a,b);
        
        //약분
        a /=n;
        b /=n;
        
        //소인수체크
        while(b%2==0) {
            b/=2;
        }
        while(b%5==0) {
            b/=5;
        }
        
        if(b==1) return 1;
        else return 2;
    }
    
    int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b,a%b);
    }
}