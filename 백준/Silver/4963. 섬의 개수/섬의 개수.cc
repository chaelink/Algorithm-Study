#include <iostream>
#include <vector>
using namespace std;

int w, h;
vector<vector<int>> grid;
vector<vector<bool>> visited;
int dx[8] = {1, -1, 0, 0, 1, 1, -1, -1};
int dy[8] = {0, 0, 1, -1, 1, -1, 1, -1};

void dfs(int x, int y) {
    visited[x][y] = true;
    for (int i = 0; i < 8; i++) {
        int nx = x + dx[i], ny = y + dy[i];
        if (nx >= 0 && nx < h && ny >= 0 && ny < w && grid[nx][ny] && !visited[nx][ny])
            dfs(nx, ny);
    }
}

int main() {
    while (true) {
        cin >> w >> h;
        if (w == 0 && h == 0) break;

        grid.assign(h, vector<int>(w));
        visited.assign(h, vector<bool>(w, false));

        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                cin >> grid[i][j];

        int count = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] && !visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        cout << count << '\n';
    }
    return 0;
}
