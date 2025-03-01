#include <iostream>
#include <vector>
using namespace std;

int dx[] = {-1,0,1,0};
int dy[] = {0,1,0,-1}; //북동남서

int main() {
    int n,m,r,c,d;
    int result=0;
    cin>>n>>m;
    vector<vector<int>> arr(n, vector<int>(m,0));
    cin>>r>>c>>d;
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            cin>>arr[i][j];
        }
    }
    
    while(1) {
        if(arr[r][c]==0) {
            arr[r][c]=2;
            result++;
        }
        bool cleaned = false;
        
        for(int i=0; i<4; i++) {
            d = (d+3)%4;
            int nr = r + dx[d];
            int nc = c + dy[d];
            if(nr>=0 && nr<n && nc>=0 && nc<m) {
                if(arr[nr][nc]==0) {
                    r = nr;
                    c = nc;
                    cleaned = true;
                    break;
                }
            }
        }
        if(!cleaned) {
            int back = (d+2)%4;
            int br = r + dx[back];
           int bc = c + dy[back];
                
            if(br<0 || br>=n || bc<0 || bc>=m || arr[br][bc]==1) {
                break;
            }
            r = br;
            c = bc;
        }
    }
    cout<< result <<'\n';
    return 0; 
        
}