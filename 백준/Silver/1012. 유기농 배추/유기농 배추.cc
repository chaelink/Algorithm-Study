#include <iostream>
#include <cstring>
using namespace std;

int check[51][51];
int dx[] = {-1,1,0,0};
int dy[] = {0,0,1,-1};
int bat[51][51];
int m,n,k;
void dfs(int x, int y) {
    check[x][y] = 1;
    for(int i=0;i<4;i++) {
        int nx = x +dx[i];
        int ny = y + dy[i];
        if(nx>=0&&nx<n&&ny>=0&&ny<m) {
            if(bat[nx][ny]==1) {
                if(check[nx][ny]==0) {
                    dfs(nx,ny);
                }
            }
        }
        else continue;
    }
}
int main() {
    int count;
    cin>>count;
    while(count--) {
        cin>>m>>n>>k;
        int cnt=0;
        for(int i=0;i<k;i++) {
            int x,y;
            cin>>x>>y;
            bat[y][x]=1;
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(bat[i][j]==1){
                    if(check[i][j]==0) {
                        cnt++;
                        dfs(i,j);
                    }
                }
            }
        }
        cout<<cnt<<'\n';
        memset(check,0,sizeof(check));
        memset(bat,0,sizeof(bat));
    }
}