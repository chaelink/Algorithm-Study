#include <iostream>
#include <queue>
#include <vector>
#include <climits>  // INT_MAX를 사용하기 위해 필요한 헤더 파일

using namespace std;

int bfs(int n, int k) {
    vector<int> dist(100001, INT_MAX);  // 최단 시간을 저장할 배열
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    
    dist[n] = 0;
    pq.push({0, n});  // 시작점 (비용, 위치)
    
    while (!pq.empty()) {
        int current_time = pq.top().first;
        int current_pos = pq.top().second;
        pq.pop();
        
        if (current_pos == k) {
            return current_time;
        }
        
        // 순간이동하는 경우 (0초 소요)
        if (current_pos * 2 <= 100000 && current_time < dist[current_pos * 2]) {
            dist[current_pos * 2] = current_time;
            pq.push({current_time, current_pos * 2});
        }
        
        // 앞으로 한 칸 이동하는 경우 (1초 소요)
        if (current_pos + 1 <= 100000 && current_time + 1 < dist[current_pos + 1]) {
            dist[current_pos + 1] = current_time + 1;
            pq.push({current_time + 1, current_pos + 1});
        }
        
        // 뒤로 한 칸 이동하는 경우 (1초 소요)
        if (current_pos - 1 >= 0 && current_time + 1 < dist[current_pos - 1]) {
            dist[current_pos - 1] = current_time + 1;
            pq.push({current_time + 1, current_pos - 1});
        }
    }
    
    return -1; // 이 코드는 실행되지 않음. 논리상 도달할 수 없는 상태
}

int main() {
    int n, k;
    cin >> n >> k;
    
    cout << bfs(n, k) << endl;
    
    return 0;
}
