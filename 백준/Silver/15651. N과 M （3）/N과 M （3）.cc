#include <iostream>
using namespace std;
int arr[8];
int visited[8][8];
int n,m;
    
void dfs(int cnt) {
    if(cnt==m) {
        for(int i=0; i<m; i++) {
            cout<<arr[i]<<" ";
        }
        cout<<"\n";
    }
    
    for(int i=1; i<=n; i++) {
        if(visited[cnt][i]==0) {
            arr[cnt]=i;
            visited[cnt][i]=1;
            dfs(cnt+1);
            visited[cnt][i]=0;
        }
    }
}

int main() {
    cin>>n>>m;
    dfs(0);
}