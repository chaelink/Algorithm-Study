#include <iostream>
using namespace std;

long long mod_exp(long long a, long long b, long long c) {
    if (b == 0) return 1;  
    
    long long half = mod_exp(a, b / 2, c);  
    
    half = (half * half) % c;  

    if (b % 2 == 0) {
        return half;  // B가 짝수일 때
    } else {
        return (half * a) % c;  // B가 홀수일 때
    }
}

int main() {
    long long a, b, c;
    cin >> a >> b >> c;
    cout << mod_exp(a, b, c) << endl;

    return 0;
}
