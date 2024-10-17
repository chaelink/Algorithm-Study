#include <iostream>

using namespace std;
int n,m;
int arr[9];
int visited[9][9];

void dfs (int num, int cnt) {
    if(cnt==m) {
        for(int i=0; i<m; i++) {
            cout<<arr[i]<<" ";
        }
        cout<<"\n";
        return;
    }
    
    for(int i=num; i<=n; i++) {
         if(visited[cnt][i]==0){
            arr[cnt]=i;
            visited[cnt][i]=1;
            dfs(i,cnt+1);
            visited[cnt][i]=0;
        }
    }
    
}



int main () {
    cin>>n>>m;
    dfs(1,0);
}