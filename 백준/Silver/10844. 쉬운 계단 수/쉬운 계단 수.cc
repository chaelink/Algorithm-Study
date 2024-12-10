#include <iostream>
#include <vector>
#define mod 1000000000;
using namespace std;
int main() {
    vector<vector<int>> dp(101,vector<int>(10,0));
    for(int i=1; i<10; i++) {
        dp[1][i]=1;
    }
    int n;
    cin>>n;
    
    for(int i=2; i<=n; i++) {
        for(int j=0; j<10; j++) {
            if(j==0) {
                dp[i][j] = dp[i-1][j+1];
            }
            else if(j==9) {
                dp[i][j] = dp[i-1][j-1];
            }
            else
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
            dp[i][j] %= mod;
        }
    }
    int result =0;
    for(int i=0; i<10; i++) {
         result = (result + dp[n][i]) % mod;
    }

    cout<< result;
    
}