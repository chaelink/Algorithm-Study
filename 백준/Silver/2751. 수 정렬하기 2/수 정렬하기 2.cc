#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int main() {
    int n,tmp;
    vector<int> a;
    cin>>n;
    for(int i=0;i<n;i++) {
        cin>>tmp;
        a.push_back(tmp);
    }
    sort(a.begin(),a.end());
    for(int i=0;i<n;i++) {
        cout<<a[i]<<"\n";
    }
}
