#include <iostream>
#include <algorithm>

using namespace std;
int n,m;
int num[9];
int arr[9];
int visited[9];

void dfs(int number, int cnt) {
    if(cnt==m) {
        for(int i=0; i<m; i++) {
            cout<<arr[i]<<" ";
        }
        cout<<"\n";
    }
    for(int i=number; i<n; i++) {
        if(visited[i]==0) {
            arr[cnt]=num[i];
            visited[i]=1;
            dfs(i+1,cnt+1);
            visited[i]=0;
        }
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