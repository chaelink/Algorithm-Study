#include <iostream>
#include <queue>
#include <vector>
using namespace std;
int n, m;
int a, b;
int visit[1001];
vector <int> vect[1001];
int component=0;

void bfs(int i) {
    queue <int> q;
    q.push(i);
    visit[i]=1;
    
    while(!q.empty()) {
        int current = q.front();
        q.pop();
        
        for(int i=0; i<vect[current].size(); i++) {
            if(visit[vect[current][i]]==0) {
                visit[vect[current][i]]=1;
                q.push(vect[current][i]);
            }
        }
    }
}

int main() {
    cin>>n>>m;
    
    for(int i=0; i<m; i++) {
        cin>>a>>b;
        vect[a].push_back(b);
        vect[b].push_back(a);
    }
    
    for(int i=1; i<=n; i++) {
        if(visit[i]==0) {
            bfs(i);
            component++;
        }
    }
    
    cout<<component;
    return 0;
  
}