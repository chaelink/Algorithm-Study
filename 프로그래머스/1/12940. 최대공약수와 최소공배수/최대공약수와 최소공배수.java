class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        answer[0] = gcd(n,m);
        answer[1] = lcm(n,m);
        
        return answer;
    }
    
    int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a%b);
    }
    
    int lcm(int a, int b) {
        return a/gcd(a,b)*b;
    }
}