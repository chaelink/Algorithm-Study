class Solution {
    int[] dp = new int[100001];
    
    public int solution(int n) {
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<n; i++) {
            fibo(i);
        }
        int answer = fibo(n);
        return answer;
    }
    
    public int fibo(int a) {
        if(a==0) {
            return dp[0];
        } else if(a==1) {
            return dp[1];
        } else {
            dp[a] = dp[a-1]%1234567 + dp[a-2]%1234567;
            return dp[a]%1234567;
        }
    }
}