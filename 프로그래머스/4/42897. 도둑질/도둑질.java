import java.util.*;

class Solution {
    public int solution(int[] money) {
        int n = money.length;

        // case 1: 첫 집을 포함, 마지막 집 제외
        int[] dp = new int[n];
        dp[0] = money[0];
        dp[1] = Math.max(money[0], money[1]);
        for (int i = 2; i < n - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i]);
        }

        // case 2: 첫 집 제외, 마지막 집 포함 가능
        int[] dp2 = new int[n];
        dp2[0] = 0;  // 첫 집 제외
        dp2[1] = money[1];
        if (n >= 3) {
            dp2[2] = Math.max(dp2[1], money[2]); // 이 부분이 핵심 수정!
            for (int i = 3; i < n; i++) {
                dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + money[i]);
            }
        }

        return Math.max(dp[n - 2], dp2[n - 1]); // case1은 마지막 집 제외
    }
}
