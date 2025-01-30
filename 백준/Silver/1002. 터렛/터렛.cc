#include <iostream>
#include <cmath>
using namespace std;

int main() {
    int t;
    cin >> t;

    while (t--) {
        int x1, y1, r1, x2, y2, r2;
        cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;

        double d = sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2)); // 두 점 사이의 거리

        if (x1 == x2 && y1 == y2 && r1 == r2) {
            cout << "-1\n"; // 두 원이 완전히 겹칠 때
        } else if (d > r1 + r2 || d < abs(r1 - r2)) {
            cout << "0\n"; // 두 원이 만나지 않을 때 (외부 또는 내부에서 떨어져 있음)
        } else if (d == r1 + r2 || d == abs(r1 - r2)) {
            cout << "1\n"; // 외접 또는 내접할 때
        } else {
            cout << "2\n"; // 두 원이 두 점에서 만날 때
        }
    }

    return 0;
}
