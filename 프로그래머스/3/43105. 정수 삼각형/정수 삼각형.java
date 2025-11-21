class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        
        //행 1부터 n-1까지
        for(int i=1; i<n; i++) {
            //열 0부터 i까지
            for(int j=0; j<=i; j++) {
                if(j==0) {
                    dp[i][j] = dp[i-1][0] + triangle[i][j];
                } else if(j==i) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
            }
        }
        
        for(int i : dp[n-1]) {
            //System.out.println(i);
            answer = Math.max(answer, i);
        }
        return answer;
    }
}