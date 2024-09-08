#include <iostream>
#include <algorithm>
using namespace std;
int n,m;
int arr[9];
int num[9];

void dfs(int h, int cnt) {
    if(cnt==m) {
        for(int i=0; i<m; i++) {
            cout<<arr[i]<<" ";
        }
        cout<<"\n";
        return ;
    }
    
    int xx=0;
    for(int i=h; i<n; i++) {
        if(xx!=num[i]) {
            arr[cnt]=num[i];
            xx=num[i];
            dfs(i,cnt+1);
        }
    }
}


int main() {
    cin>>n>>m;
    for(int i=0; i<n; i++) {
        cin>>num[i];
    }
    sort(num, num+n);
    dfs(0,0);
}