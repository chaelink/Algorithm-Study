#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int n;
    cin>>n;
    vector<int> lop(n,0);
    vector<int> w(n,0);
    for(int i=0; i<n; i++) {
        cin>>lop[i];
    }
    sort(lop.begin(), lop.end(), greater<int>());
    
    for(int i=0; i<n; i++) {
        w[i] = lop[i]*(i+1);
    }
    sort(w.begin(), w.end(), greater<int>());
    cout<<w[0];
    return 0;
}