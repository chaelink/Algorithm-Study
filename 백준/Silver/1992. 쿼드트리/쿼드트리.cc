#include <iostream>
#include <vector>
using namespace std;

vector<string> image;


void compress(int x, int y, int size) {
    char first = image[x][y]; // 첫 번째 값 (0 또는 1)
    bool isSame = true;

    for (int i = x; i < x + size; i++) {
        for (int j = y; j < y + size; j++) {
            if (image[i][j] != first) {
                isSame = false;
                break;
            }
        }
        if (!isSame) break;
    }

    if (isSame) {
        cout << first;
        return;
    }

    // 다르면 4등분하여 재귀적으로 압축
    cout << "(";
    int newSize = size / 2;
    compress(x, y, newSize);                 // 왼쪽 위
    compress(x, y + newSize, newSize);        // 오른쪽 위
    compress(x + newSize, y, newSize);        // 왼쪽 아래
    compress(x + newSize, y + newSize, newSize); // 오른쪽 아래
    cout << ")";
}

int main() {
    int n;
    cin >> n;
    image.resize(n);

    for (int i = 0; i < n; i++) {
        cin >> image[i]; // 한 줄씩 입력 받기
    }

    compress(0, 0, n);
    cout << endl;

    return 0;
}
