#include <iostream>
#include <vector>
#include <queue>

using namespace std;

void findParents(int n, vector<vector<int>>& tree, vector<int>& parents) {
    queue<int> q;
    q.push(1); // 루트 노드
    parents[1] = 0; 

    while (!q.empty()) {
        int current = q.front();
        q.pop();

        for (int neighbor : tree[current]) {
            if (parents[neighbor] == -1) { // 아직 방문하지 않은 노드
                parents[neighbor] = current; 
                q.push(neighbor); 
            }
        }
    }
}

int main() {
    int n;
    cin >> n;

    vector<vector<int>> tree(n + 1);
    vector<int> parents(n + 1, -1); 

    for (int i = 0; i < n - 1; ++i) {
        int u, v;
        cin >> u >> v;
        tree[u].push_back(v);
        tree[v].push_back(u);
    }

    findParents(n, tree, parents);

    for (int i = 2; i <= n; ++i) {
        cout << parents[i] << "\n";
    }

    return 0;
}
