#include <iostream>
using namespace std;

long long dp[31][31];

long long combination(int n, int r) {
    if (dp[n][r] != 0) return dp[n][r];
    if (n == r || r == 0) return dp[n][r] = 1;
    return dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
}

int main() {
    int T;
    cin >> T;
    while (T--) {
        int N, M;
        cin >> N >> M;
        cout << combination(M, N) << "\n";
    }
    return 0;
}