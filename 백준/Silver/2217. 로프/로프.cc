#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int n;
    cin>>n;
    vector<int> lop(n,0);
    int result=0;
    for(int i=0; i<n; i++) {
        cin>>lop[i];
    }
    sort(lop.begin(), lop.end(), greater<int>());
    
    for(int i=0; i<n; i++) {
        result = max(result,lop[i]*(i+1) );
    }
    
    cout<<result;
    return 0;
}