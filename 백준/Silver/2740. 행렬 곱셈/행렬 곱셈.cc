#include <iostream>
#include <vector>
using namespace std;
int main() {
    int n,m;
    cin>>n>>m;
    
    vector<vector<int>> a(n,vector<int>(m,0));
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            cin>>a[i][j];
        }
    }
    
    int k;
    cin>>m>>k;
    vector<vector<int>> b(m,vector<int>(k,0));
    for(int i=0; i<m; i++) {
        for(int j=0; j<k; j++) {
            cin>>b[i][j];
        }
    }
    
    vector<vector<int>> c(n, vector<int>(k,0));
    for(int i=0; i<n; i++) {
        for(int j=0; j<k; j++) {
            for(int p=0; p<m; p++) {
                c[i][j] += a[i][p]*b[p][j];
            }
            cout<<c[i][j]<<" ";
        }
        cout<<'\n';
    }
    
    
    
}