#include <iostream>
#include <string>
#include <vector>
using namespace std;

int main() {
    string s;
    cin >> s;
    vector<int> positions(26, -1);

    for (int i = 0; i < s.length(); i++) {
        int index = s[i] - 'a'; 
        if (positions[index] == -1) { 
            positions[index] = i;
        }
    }
    for (int i = 0; i < 26; i++) {
        cout << positions[i] << " ";
    }

    return 0;
}
