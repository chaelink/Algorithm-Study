#include <iostream>
#include <queue>
#include <vector>
using namespace std;

int n,m,h;
int result=0;
//vector<vector<vector<int>>> 
int arr[102][102][102];
queue <pair<pair<int,int>,int>> q;
int dx[] = {0,0,1,-1,0,0};
int dy[] = {1,-1,0,0,0,0};
int dz[] = {0,0,0,0,1,-1};

void bfs() {
    while(!q.empty()) {
        int xx= q.front().first.first;
        int yy = q.front().first.second;
        int zz = q.front().second;
        q.pop();
        
        for(int i=0; i<6; i++) {
            int nx = xx+dx[i];
            int ny = yy+dy[i];
            int nz = zz+dz[i];
            
            if(nx>=0 && nx<n && ny>=0 && ny<m && nz>=0 && nz<h) {
                if(arr[nx][ny][nz]==0) {
                    arr[nx][ny][nz]=arr[xx][yy][zz]+1;
                    q.push(make_pair(make_pair(nx,ny),nz));
                }
            }
        }
    }
}



int main() {
    cin>>m>>n>>h;
    
    for(int k=0;k<h;k++) {
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                cin>>arr[i][j][k];
                if(arr[i][j][k]==1)
                    q.push(make_pair(make_pair(i,j),k));
            }
        }
    }
    
    bfs();
    
    for(int k=0;k<h;k++) {
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if (arr[i][j][k]==0) {
                    cout<<-1;
                    return 0;
                }
                if(arr[i][j][k]>result)
                    result = arr[i][j][k];
            }
        }
    }
    cout << result-1;
    return 0;
    
}