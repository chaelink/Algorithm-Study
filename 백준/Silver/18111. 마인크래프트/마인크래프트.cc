#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n, m, b;
    cin >> n >> m >> b;

    vector<vector<int>> land(n, vector<int>(m));
    int minH = 256, maxH = 0;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> land[i][j];
            minH = min(minH, land[i][j]);
            maxH = max(maxH, land[i][j]);
        }
    }

    int minTime = 1e9, bestHeight = 0;

    for (int h = minH; h <= maxH; h++) {
        int removeBlocks = 0, addBlocks = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int diff = land[i][j] - h;
                if (diff > 0) removeBlocks += diff;
                else addBlocks -= diff;
            }
        }

        if (removeBlocks + b >= addBlocks) {
            int time = removeBlocks * 2 + addBlocks;
            if (time <= minTime) {
                minTime = time;
                bestHeight = h;
            }
        }
    }

    cout << minTime << " " << bestHeight << endl;
    return 0;
}
