#include <iostream>
#include <algorithm>
using namespace std;
int arr[8];
int num[8];
int n,m;

void dfs(int cnt) {
    if(cnt==m) {
        for(int i=0; i<m; i++) {
            cout<<arr[i]<<" ";
        }
        cout<<"\n";
        return;
    }
    int xx = 0;
    for(int i=0; i<n; i++) {
        if(xx!=num[i]) {
            arr[cnt]=num[i];
            xx=num[i];
            dfs(cnt+1);
        }
    }
}



int main() {
    cin>>n>>m;
    for(int i=0; i<n; i++) {
        cin>>num[i];
    }
    sort(num, num+n);
    dfs(0);
}