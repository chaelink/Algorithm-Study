#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main() {
    int N, M;
    cin >> N >> M;

    vector<int> inDegree(N + 1, 0);
    vector<vector<int>> graph(N + 1);
    queue<int> q;
    vector<int> result;

    for (int i = 0; i < M; i++) {
        int A, B;
        cin >> A >> B;
        graph[A].push_back(B);
        inDegree[B]++;
    }

    for (int i = 1; i <= N; i++) {
        if (inDegree[i] == 0) {
            q.push(i);
        }
    }

    while (!q.empty()) {
        int current = q.front();
        q.pop();
        result.push_back(current);

        for (int next : graph[current]) {
            inDegree[next]--;
            if (inDegree[next] == 0) {
                q.push(next);
            }
        }
    }

    for (int student : result) {
        cout << student << " ";
    }
    cout << '\n';

    return 0;
}
