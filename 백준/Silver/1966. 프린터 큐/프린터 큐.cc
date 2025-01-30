#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int main() {
    int t;
    cin >> t;

    while (t--) {
        int n, m;
        cin >> n >> m;

        queue<pair<int, int>> q;  
        priority_queue<int> pq;   

        for (int i = 0; i < n; i++) {
            int priority;
            cin >> priority;
            q.push({priority, i});
            pq.push(priority);
        }

        int print_order = 0;

        
        while (!q.empty()) {
            int cur_priority = q.front().first;
            int cur_index = q.front().second;
            q.pop();

            if (cur_priority == pq.top()) {
                pq.pop();
                print_order++;

                if (cur_index == m) {
                    cout << print_order << "\n";
                    break;
                }
            } else {
                q.push({cur_priority, cur_index});
            }
        }
    }

    return 0;
}
