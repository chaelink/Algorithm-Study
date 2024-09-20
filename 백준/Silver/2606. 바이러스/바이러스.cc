#include <iostream>
#
using namespace std;
int n;
int arr[101][101];
int visited[101];
int count = 0;
void dfs(int v) {
    visited[v] = 1;
    count++;
    for(int i=1;i<=n;i++) {
        if( arr[v][i] == 1 && visited[i] == 0) {
            dfs(i);
        }
        if(i==n)
            return ;
    }
}
int main() {
    cin>>n;
    int m;
    cin>>m;
    for(int i=0;i<m;i++) {
        int a,b;
        cin>>a>>b;
        arr[a][b] = 1;
        arr[b][a] = 1;
    }
    dfs(1);
    
    cout<<count -1 ;
    
}