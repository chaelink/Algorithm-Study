#include <iostream>
#include <algorithm>
using namespace std; 

bool visited[26][26];
string arr[26];
int danji=0;
int dan[26*26]={0, };
int dx[] = {1,-1,0,0};
int dy[] = {0,0,-1,1};
int k;
    
void dfs(int x, int y) {
    visited[x][y] = true;
    dan[danji] += 1;
    for(int i=0;i<4;i++){
        int nx = x + dx[i];
        int ny = y + dy[i]; 
        if(nx>=0&&nx<k&&ny>=0&&ny<k){
            if(arr[nx][ny]=='1'&&!visited[nx][ny]) {
                dfs(nx,ny);
            }
            
        }
     
    }
}


int main() {
    cin >> k;
    
    for(int i=0;i<k;i++){
        cin >> arr[i];
    }
    for(int i=0;i<k;i++){
        for(int j=0;j<k;j++){
            if(arr[i][j]== '1' && !visited[i][j]) {
                danji++;
                dfs(i,j);
            }
        }
    }
    sort(dan+1,dan+danji+1);
    cout<<danji<<'\n';
    for(int i=1;i<danji+1;i++) {
        cout<<dan[i]<<'\n';
    }
}