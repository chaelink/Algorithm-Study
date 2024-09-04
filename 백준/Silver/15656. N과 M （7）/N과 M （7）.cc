#include <iostream>
#include <algorithm>
using namespace std;
int n,m;
int arr[8];
int num[8];

void dfs(int cnt) {
    if(cnt == m) {
        for(int i=0; i<m; i++) {
            cout<<arr[i]<<" ";
        }
        cout<<"\n";
        return ;
    }
    
    for(int i=0; i<n; i++) {
        arr[cnt]=num[i];
        dfs(cnt+1);
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