#include <iostream>
#include <list>
#include <string>
using namespace std;

int main() {
    int n;
    cin >> n;
    
    while (n--) {
        string input;
        cin >> input;  // 한 줄 전체 입력 받기

        list<char> sen;  // 에디터 역할 리스트
        auto it = sen.begin();  // 커서를 리스트 맨 앞에 둠

        for (char c : input) {  // 입력 문자열의 각 문자 처리
            if (c == '<') {
                if (it != sen.begin()) it--;  // 왼쪽 이동
            } 
            else if (c == '>') {
                if (it != sen.end()) it++;  // 오른쪽 이동
            } 
            else if (c == '-') {
                if (it != sen.begin()) {  // 왼쪽 문자 삭제
                    it--;
                    it = sen.erase(it);
                }
            } 
            else {  // 글자 삽입
                sen.insert(it, c);
            }
        }

        for (char x : sen) cout << x;  // 리스트 출력
        cout << '\n';
    }

    return 0;
}
