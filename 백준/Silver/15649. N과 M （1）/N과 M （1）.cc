#include <iostream>
using namespace std;
int n,m;
int arr[9];
int visited[9];

void dfs(int cnt) {
    if(cnt==m) {
        for(int i=0;i<m;i++) {
            cout<<arr[i]<<" ";
        }
        cout<<"\n";
    }
    
    for(int i=1; i<=n; i++) {
        if(visited[i]==0) {
            arr[cnt]=i;
            visited[i]=1;
            dfs(cnt+1);
            visited[i]=0;
        }
    }
    
}


int main() {
    cin>>n>>m;
    dfs(0);
    
}