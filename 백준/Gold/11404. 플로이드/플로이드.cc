#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

const int INF = 1e9;  // 무한대 값 설정 (충분히 큰 값)

int main() {
    int n, m;
    cin >> n >> m;

    // 초기화: 모든 값을 INF로 초기화
    vector<vector<int>> adj(n, vector<int>(n, INF));

    // 자기 자신으로 가는 경로는 0으로 설정
    for (int i = 0; i < n; i++) {
        adj[i][i] = 0;
    }

    // 버스 정보 입력 처리
    for (int i = 0; i < m; i++) {
        int a, b, c;
        cin >> a >> b >> c;
        a--; b--;  // 1-based 인덱스를 0-based로 변환
        adj[a][b] = min(adj[a][b], c);  // 동일한 경로에 여러 버스가 있을 수 있으므로 최소 비용으로 설정
    }

    // 플로이드-워셜 알고리즘 적용
    for (int k = 0; k < n; k++) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adj[i][k] < INF && adj[k][j] < INF) {
                    adj[i][j] = min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }
    }

    // 결과 출력
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (adj[i][j] == INF) {
                cout << 0 << " ";  // 경로가 없는 경우 0을 출력
            } else {
                cout << adj[i][j] << " ";  // 최소 비용 출력
            }
        }
        cout << "\n";
    }

    return 0;
}
