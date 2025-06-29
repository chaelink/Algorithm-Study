class Solution {
    public long solution(int n) {
        //long answer = 0;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        //dp[2] = 2;
        //dp[3] = 3;
        //dp[4] = 5;
        
        if(n==1) {
            return 1;
        }
        for(int i=2; i<=n; i++) {
            dp[i] = (dp[i-1]%1234567 + dp[i-2]%1234567)%1234567;
        }
        return dp[n];
    }
}