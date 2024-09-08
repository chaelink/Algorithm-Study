#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
    int n, m;
    
    // 배열 입력
    cin >> n;
    vector<int> arr(n);
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    sort(arr.begin(), arr.end());  // 정렬

    // 찾을 값 입력
    cin >> m;
    vector<int> targets(m);
    for (int i = 0; i < m; i++) {
        cin >> targets[i];
    }

    // 이진 탐색
    for (int i = 0; i < m; i++) {
        int low = 0, high = n - 1;
        bool found = false;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == targets[i]) {
                found = true;
                break;
            } else if (targets[i] > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        // 결과 출력
        cout << (found ? "1 " : "0 ");
    }

    return 0;
}
