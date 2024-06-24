#include <iostream>
#include <queue>
using namespace std;

int m,n;
int tomato[1000][1000];
int result = 0;
queue <pair<int,int>> q;
int xd[] = {-1, 1, 0, 0};
int yd[] = {0, 0, -1, 1};

void bfs() {
    while(!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        
        for(int i=0;i<4;i++) {
            int nx = x+xd[i];
            int ny = y+yd[i];
            
            if(nx>=0&&nx<n&&ny>=0&&ny<m) {
                if(tomato[nx][ny]==0) {
                    tomato[nx][ny] = tomato[x][y]+1;
                    q.push(make_pair(nx,ny));
                }
            }
        }
    }
}


int main() {
    
    cin>>m>>n;   
    for(int i=0;i<n;i++) {
        for(int j=0;j<m;j++) {
            cin>>tomato[i][j];
            if(tomato[i][j]==1)
                q.push(make_pair(i,j));
        }
    }
    bfs();
    
    for(int i=0;i<n;i++) {
        for(int j=0;j<m;j++) {
            if(tomato[i][j]==0) {
                cout<<-1<<'\n';
                return 0;
            }
            if(tomato[i][j]>result)
                result = tomato[i][j];
        }
    }
    cout<<result-1<<'\n';
    return 0;
    
 
}