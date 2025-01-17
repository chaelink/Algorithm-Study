#include <iostream>
using namespace std;

int main() {
    int change;
    cin >> change;
    change = 1000 - change;

    int coins[] = {500, 100, 50, 10, 5, 1};
    int count = 0;

    for (int i = 0; i < 6; i++) {
        if (change == 0) break; 
        count += change / coins[i]; 
        change %= coins[i]; 
    }

    cout << count << endl; 
    return 0;
    
    
}
