#include <iostream>
#include <cstring>
//R=1, G=2, B=3
using namespace std;
int n;
int arr[101][101];
int arr2[101][101];
int visited[101][101];
int result1=0, result2=0;
int movex[] = {1,-1,0,0};
int movey[] = {0,0,1,-1};



void dfs(int i, int j) {
    visited[i][j]=1;
    
    for(int k=0; k<4; k++) {
        int nx = i + movex[k];
        int ny = j + movey[k];
        
        if(nx>=0 && nx<n && ny>=0 && ny<n && arr[i][j]==arr[nx][ny] && visited[nx][ny]==0) {
            dfs(nx,ny);
        }
    } 
}
void dfs2(int i, int j) {
    visited[i][j]=1;
    
    for(int k=0; k<4; k++) {
        int nx = i + movex[k];
        int ny = j + movey[k];
        
        if(nx>=0 && nx<n && ny>=0 && ny<n && arr2[i][j]==arr2[nx][ny] && visited[nx][ny]==0) {
            dfs2(nx,ny);
        }
    } 
}


int main() {
    cin>>n;
    char color;
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            cin>>color;
            if(color=='R') { arr[i][j]=1; arr2[i][j]=1;}
               
            if(color=='G') { arr[i][j]=2; arr2[i][j]=1;}
               
            if(color=='B') { arr[i][j]=3; arr2[i][j]=3;}
               
        }
    }
    
    
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            if(!visited[i][j]) {
                result1++;
                dfs(i,j);
            }
        }
    }
    memset(visited,0,sizeof(visited));
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            if(!visited[i][j]) {
                result2++;
                dfs2(i,j);
            }
        }
    }
    cout<<result1<<" "<<result2;
    
}