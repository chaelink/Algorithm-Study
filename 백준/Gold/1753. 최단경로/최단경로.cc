#include <iostream>
#include <vector>
#include <queue>
#include <limits>

using namespace std;

const int INF = numeric_limits<int>::max();

typedef pair<int, int> pii;

vector<vector<pii>> graph;
vector<int> dist;

void dijkstra(int start) {
    priority_queue<pii, vector<pii>, greater<pii>> pq;
    pq.push({0, start});
    dist[start] = 0;

    while (!pq.empty()) {
        int current_dist = pq.top().first;
        int current = pq.top().second;
        pq.pop();

        if (current_dist > dist[current]) continue;

        for (auto& edge : graph[current]) {
            int next = edge.second;
            int cost = edge.first;

            if (dist[current] + cost < dist[next]) {
                dist[next] = dist[current] + cost;
                pq.push({dist[next], next});
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int V, E, K;
    cin >> V >> E >> K;
    graph.resize(V + 1);
    dist.assign(V + 1, INF);

    for (int i = 0; i < E; ++i) {
        int u, v, w;
        cin >> u >> v >> w;
        graph[u].push_back({w, v});
    }

    dijkstra(K);

    for (int i = 1; i <= V; ++i) {
        if (dist[i] == INF) cout << "INF\n";
        else cout << dist[i] << "\n";
    }

    return 0;
}
