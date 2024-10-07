#include <iostream>
#include <vector>
using namespace std;


int main() {
    int n;
    cin>>n;
    vector<vector<int>>adj(n,vector<int>(n));
    
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            cin>>adj[i][j];
        }
    }
    
    for(int k=0; k<n; k++) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(adj[i][k] && adj[k][j])
                    adj[i][j]=1;
            }
        }
    }
    
     for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            cout<<adj[i][j]<<" ";
        }
         cout<<"\n";
    }
    
}