#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<int> sticker)
{
    int n = sticker.size();
    vector<int> dp(n,0);   
    
    if(n==1) {
        return sticker[0];
    }
    
    if(n==2) {
        return max(sticker[0], sticker[1]);
    }
    
    // 첫번째 수를 선택 O
    dp[0]=sticker[0];
    dp[1]=dp[0];
    for(int i=2; i<n-1; i++) {
        dp[i]= max(dp[i-1], dp[i-2]+sticker[i]);
    }
    dp[n-1]=dp[n-2];
    
    int answer1 = dp[n-1];
    
    // 첫번째 수를 선택 X
    dp[0]=0;
    for(int i=1; i<n; i++) {
        dp[i]= max(dp[i-1], dp[i-2]+sticker[i]);
    }
    
    int answer =  max(answer1, dp[n-1]);
    
    return answer;
}