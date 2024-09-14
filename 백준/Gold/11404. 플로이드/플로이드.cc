#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int n,m;
int max = 1e9;

int main() {
    cin>>n;
    vector<vector<int>> adj(n,vector<int>(n,1e9));
    for(int i=0; i<n; i++) {
        adj[i][i]=0;
    }
    cin>>m;
    int a,b,c;
    for(int i=0; i<m; i++) {
        cin>>a>>b>>c;
        a--;b--;
        adj[a][b] = min(adj[a][b],c);
    }
    for(int i=0; i<n; i++) {
        adj[i][i]=0;
    }
    
    for(int k=0; k<n; k++) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                adj[i][j]=min(adj[i][k]+adj[k][j],adj[i][j]);
            }
        }
    }
    
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            if(adj[i][j]==1e9)
                cout<<"0 ";
            else
                cout<<adj[i][j]<<" ";
        }
        cout<<"\n";
    }
    
}