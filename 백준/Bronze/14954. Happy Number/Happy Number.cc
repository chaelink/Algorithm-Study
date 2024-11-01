#include <iostream>
using namespace std;
#define MAXN ((int)1e3)

int N;
int used[MAXN + 10];

void InputData() {
    cin >> N;
}

int cal(int number) {
    int sol = 0;
    int tmp = number;

    while (number != 0) {
        tmp = (number % 10);
        sol += (tmp * tmp);
        number /= 10;
    }
    return sol;
}

void Solve(int num) {

    while (1)
    {
        num = cal(num);

        if (num == 1) {
            cout << "HAPPY";
            return;
        }

        else if (used[num] == 1) break;

        used[num] = 1;
    }
    cout << "UNHAPPY";
}

int main() {

    InputData();

    Solve(N);

    return 0;
}