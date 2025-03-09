#include <iostream>
using namespace std;


bool isHanNumber(int n) {
    
    if (n < 100) return true;  // 1~99

    int a = n / 100;       
    int b = (n / 10) % 10; 
    int c = n % 10;        

    return (a - b == b - c);  
}

int main() {
    int N, count = 0;
    cin >> N;

    for (int i = 1; i <= N; i++) {
        if (isHanNumber(i)) count++;
    }

    cout << count << '\n';
    return 0;
}
