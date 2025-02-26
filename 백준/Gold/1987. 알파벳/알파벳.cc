#include <iostream>
#include <vector>
using namespace std;
int r,c,maxlen=0;
vector<vector<char>> arr;
vector<int> visit(26,0);
int mx[4] ={0,0,1,-1};
int my[4] ={1,-1,0,0};

void dfs(int x, int y, int sum) {
    int a = arr[x][y]-'A';
    visit[a]=1;
    maxlen = max(maxlen, sum);
    
    for(int i=0; i<4; i++) {
        int nx = x+mx[i];
        int ny = y+my[i];
        int nn = arr[x+mx[i]][y+my[i]] - 'A';
        if(nx>=0 && nx<r && ny>=0 && ny<c) {
            if(visit[nn]==0) {
                dfs(x+mx[i],y+my[i],sum+1);
                visit[nn]=0;
            }
        }
    }
}

int main() {
    cin>>r>>c;
    arr.resize(r,vector<char>(c,0));
    for(int i=0; i<r; i++) {
        for(int j=0; j<c; j++) {
            cin>>arr[i][j];
        }
    }
    dfs(0,0,1);
    
    cout<<maxlen<<'\n';
    return 0;
    
    
}