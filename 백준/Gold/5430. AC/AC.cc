#include <iostream>
#include <deque>
#include <sstream>
#include <string>
using namespace std;

void solve() {
    string p, arr;
    int n;
    cin >> p >> n >> arr;

    deque<int> dq;
    string num = "";

    for (char c : arr) {
        if (isdigit(c)) {
            num += c;
        } else if (!num.empty()) {
            dq.push_back(stoi(num));
            num = "";
        }
    }


    bool reverse = false;
    for (char cmd : p) {
        if (cmd == 'R') {
            reverse = !reverse;  // 뒤집기 여부 
        } else if (cmd == 'D') {
            if (dq.empty()) {
                cout << "error\n";
                return;
            }
            if (reverse) {
                dq.pop_back();  // 뒤집힌 상태면 뒤에서 제거
            } else {
                dq.pop_front(); // 정방향이면 앞에서 제거
            }
        }
    }


    cout << "[";
    if (reverse) {
        for (auto it = dq.rbegin(); it != dq.rend(); ++it) {
            cout << *it;
            if (it + 1 != dq.rend()) cout << ",";
        }
    } else {
        for (auto it = dq.begin(); it != dq.end(); ++it) {
            cout << *it;
            if (it + 1 != dq.end()) cout << ",";
        }
    }
    cout << "]\n";
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int T;
    cin >> T;
    while (T--) {
        solve();
    }

    return 0;
}
