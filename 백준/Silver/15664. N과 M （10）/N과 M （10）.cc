#include <iostream>
#include <algorithm>
using namespace std;
int n,m;
int num[9];
int visited[9];
int arr[9];
void dfs(int here, int cnt) {
    if(cnt==m) {
        for(int i=0; i<m; i++) {
            cout<<arr[i]<<" ";
        }
        cout<<"\n";
        
    }
    
    int last=0;
    
    for(int i=here; i<n; i++) {
        if(visited[i]==0 && last!=num[i]) {
            arr[cnt]=num[i];
            visited[i]=1;
            last = num[i];
            dfs(i,cnt+1);
            visited[i]=0;
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