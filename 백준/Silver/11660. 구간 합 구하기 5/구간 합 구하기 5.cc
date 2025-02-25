#include <iostream>
#include <vector>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, M;
    cin >> N >> M;

    vector<vector<int>> arr(N + 1, vector<int>(N + 1, 0));
    vector<vector<int>> prefixSum(N + 1, vector<int>(N + 1, 0));

    for (int i = 1; i <= N; i++)
        for (int j = 1; j <= N; j++) {
            cin >> arr[i][j];
            prefixSum[i][j] = arr[i][j] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
        }

    while (M--) {
        int x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;
        cout << prefixSum[x2][y2] - prefixSum[x1 - 1][y2] - prefixSum[x2][y1 - 1] + prefixSum[x1 - 1][y1 - 1] << '\n';
    }

    return 0;
}
