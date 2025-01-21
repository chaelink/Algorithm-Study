#include <iostream>
#include <vector>
using namespace std;

int main() {
    int n;
    cin >> n;

    vector<pair<int, int>> people(n); 
    vector<int> rank(n, 1); 

    for (int i = 0; i < n; i++) {
        cin >> people[i].first >> people[i].second; 
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (i == j) continue; 
            if (people[i].first < people[j].first && people[i].second < people[j].second) {
                rank[i]++; 
            }
        }
    }
    for (int i = 0; i < n; i++) {
        cout << rank[i] << " ";
    }
    cout << endl;

    return 0;
}
