#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int n, m;
int lab[8][8];
int temp[8][8];
vector<pair<int, int>> virus;
vector<pair<int, int>> empty_spaces;
int dx[] = { -1, 1, 0, 0 };
int dy[] = { 0, 0, -1, 1 };

// 바이러스 퍼뜨리는 함수 (BFS 사용)
void spread_virus() {
    queue<pair<int, int>> q;
    for (auto v : virus) {
        q.push(v);
    }

    while (!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (temp[nx][ny] == 0) {
                    temp[nx][ny] = 2; // 바이러스 확산
                    q.push({ nx, ny });
                }
            }
        }
    }
}

// 안전 구역 계산 함수
int get_safe_area() {
    int safe_area = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (temp[i][j] == 0) {
                safe_area++;
            }
        }
    }
    return safe_area;
}

// 메인 로직 (벽을 3개 세우고 바이러스 퍼뜨림)
int main() {
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> lab[i][j];
            if (lab[i][j] == 2) {
                virus.push_back({ i, j }); // 바이러스 위치 저장
            } else if (lab[i][j] == 0) {
                empty_spaces.push_back({ i, j }); // 빈 칸 위치 저장
            }
        }
    }

    int max_safe_area = 0;
    
    // 빈 칸 중에서 3개의 칸을 선택하는 모든 조합을 시도
    vector<int> comb(empty_spaces.size(), 0);
    fill(comb.end() - 3, comb.end(), 1); // 3개 선택

    do {
        // temp 배열을 초기화 (lab 복사)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = lab[i][j];
            }
        }

        // 선택한 3개의 빈 칸에 벽 세우기
        for (int i = 0; i < empty_spaces.size(); i++) {
            if (comb[i] == 1) {
                int x = empty_spaces[i].first;
                int y = empty_spaces[i].second;
                temp[x][y] = 1; // 벽 설치
            }
        }

        // 바이러스 확산
        spread_virus();

        // 안전 구역 계산
        max_safe_area = max(max_safe_area, get_safe_area());

    } while (next_permutation(comb.begin(), comb.end()));

    cout << max_safe_area << endl;

    return 0;
}
