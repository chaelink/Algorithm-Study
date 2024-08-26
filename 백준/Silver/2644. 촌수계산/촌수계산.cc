#include <iostream>
using namespace std;
int n, m;
int a, b;
int arr[101][101];
int visited[101];
int ans=-1;

void dfs(int v, int count) {
    visited[v]=1;
    if(v == b) {
        ans = count;
        cout<< ans ;
    }
    
    for(int i=1; i<=n; i++) {
        if(arr[v][i]==1 && visited[i]==0) {
            dfs(i, count+1);
        }
    }
}



int main() {
    cin>>n;
    cin>>a>>b;
    cin>>m;
    int c, d;
    for(int i=0; i<m; i++) {
        cin>>c>>d;
        arr[c][d]=1;
        arr[d][c]=1;
    }
        dfs(a,0);
    if(visited[b]==0) {
        cout<<"-1";
    }
        
    return 0;    
    
    
    
}