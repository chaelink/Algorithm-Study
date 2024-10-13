#include <iostream>
using namespace std;
int arr[9];
int visited[9];
int n,m;

void dfs(int num, int cnt) {
    if(cnt==m) {
        for(int i=0; i<m; i++) {
            cout<<arr[i]<<" ";
        }
        cout<<"\n";
    }
    
    for(int i=num; i<=n; i++) {
        if(visited[i]==0) {
            arr[cnt]=i;
            visited[i]=1;
            dfs(i+1,cnt+1);
            visited[i]=0;
        }
    }
}



int main(){
    cin>>n>>m;
    dfs(1,0);
    
}