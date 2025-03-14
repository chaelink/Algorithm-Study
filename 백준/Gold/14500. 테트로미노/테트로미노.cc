#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int visited[500][500]; 
vector<vector<int>> arr;
int dx[] = {1, -1, 0, 0};
int dy[] = {0, 0, 1, -1};
int maxv = 0;
int n, m;

void dfs(int x, int y, int depth, int sum) {
    if (depth == 4) {  
        maxv = max(maxv, sum);
        return;
    }

    visited[x][y] = 1;  

    for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
            dfs(nx, ny, depth + 1, sum + arr[nx][ny]);
        }
    }

    visited[x][y] = 0;  
}

void t(int x, int y) {
    int sum, nx, ny;
    for (int i = 0; i < 4; i++) {
        sum = arr[x][y];
        bool valid = true;
        
        for (int j = 0; j < 4; j++) {
            if (j == i) continue;  
            nx = x + dx[j];
            ny = y + dy[j];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                valid = false;
                break;
            }
            sum += arr[nx][ny];
        }
        
        if (valid) {
            maxv = max(maxv, sum);
        }
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> n >> m;
    arr.resize(n, vector<int>(m, 0));

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> arr[i][j];
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            dfs(i, j, 1, arr[i][j]);  
            t(i, j);
        }
    }

    cout << maxv;
    return 0;
}
