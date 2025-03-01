#include <iostream>
#include <stack>
#include <vector>
using namespace std;

int main() {
    ios::sync_with_stdio(false);  // C 스타일 입출력과의 동기화 해제
    cin.tie(NULL);  // cin 성능 개선
    cout.tie(NULL); // cout 성능 개선

    int n;
    cin >> n;

    stack<int> s;
    vector<char> result;  // 연산 순서 기록

    int current = 1;  // 1부터 push 시작

    for (int i = 0; i < n; i++) {
        int target;
        cin >> target;

        // 필요한 숫자까지 push
        while (current <= target) {
            s.push(current++);
            result.push_back('+');
        }

        // 스택 top이 목표 숫자와 같아야 pop 가능
        if (s.top() == target) {
            s.pop();
            result.push_back('-');
        } else {
            // 순서 맞출 수 없음
            cout << "NO\n";
            return 0;  // 프로그램 즉시 종료
        }
    }

    // 연산 기록 한꺼번에 출력
    for (char op : result) {
        cout << op << '\n';
    }

    return 0;
}
