#include <string>
#include <vector>
#include <algorithm>
using namespace std;

string tok(int n, int k) {
    string result = "";
    while (n > 0) {
        result += to_string(n % k);
        n /= k;
    }
    reverse(result.begin(), result.end());
    return result;
}

bool isprime(long long n) {
    if (n < 2) return false;
    for (long long i = 2; i * i <= n; i++)
        if (n % i == 0) return false;
    return true;
}

int solution(int n, int k) {
    int answer = 0;
    string s = tok(n, k);
    string num = "";

    for (char c : s) {
        if (c == '0') {
            if (!num.empty() && isprime(stoll(num))) {
                answer++;
            }
            num = "";
        } else {
            num += c;
        }
    }

    if (!num.empty() && isprime(stoll(num))) {
        answer++;
    }

    return answer;
}
