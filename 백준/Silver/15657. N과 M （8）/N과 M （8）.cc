#include <iostream>
#include <algorithm>
using namespace std;

int n,m;
int num[9];
int arr[9];
int visited[9];

void dfs(int check, int cnt) {
    if(cnt==m) {
        for(int i=0; i<m; i++) {
            cout<<arr[i]<<" ";
        }
        cout<<"\n";
        return;
    }
    for(int i=check; i<n; i++) {
        arr[cnt]=num[i];
        dfs(i,cnt+1);   
    }
}

int main() {
    cin>>n>>m;
    for(int i=0; i<n; i++) {
        cin>>num[i];
    }
    sort(num,num+n);
    dfs(0,0);
}