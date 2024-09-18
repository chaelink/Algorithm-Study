#include<iostream>
#include<vector>
using namespace std;
int main() {
    vector<int> dp(12);
    int n,input;
    cin>>n;
    dp[0]=0;
    dp[1]=1;
    dp[2]=2;
    dp[3]= 4;
    dp[4]=7;
    for(int i=5;i<=11;i++) {
        dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
    }
    for(int i=0;i<n;i++) {
        cin>>input;
        cout<<dp[input]<<'\n';
    }
    return 0;
}