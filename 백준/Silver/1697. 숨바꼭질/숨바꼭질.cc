#include <iostream>
#include <queue>
using namespace std;

int n,k;
int visit[100001];
queue<pair<int,int>> q;
void bfs() {
    while(!q.empty()) {
        int now = q.front().first;
        int time = q.front().second;
        q.pop();
        if(now==k) {
            cout<<time<<'\n';
            break;
        }
        
        if(now-1>=0 && now-1<=100000) {
            if(visit[now-1]==0) {
                q.push(make_pair(now-1,time+1));
                visit[now-1]=1;
            }
        }
        if(now+1>=0 && now+1<=100000) {
            if(visit[now+1]==0) {
                q.push(make_pair(now+1,time+1));
                visit[now+1]=1;
            }
        }
        if(now*2>=0 && now*2<=100000) {
            if(visit[now*2]==0) {
                q.push(make_pair(2*now,time+1));
                visit[now*2]==1;
            }
        }
        
    }
}

int main () {
    cin>>n>>k;
    q.push(make_pair(n,0));
    visit[n]=1;
    bfs();
    return 0;
}