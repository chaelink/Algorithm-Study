#include <iostream>
#include <queue>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    priority_queue<pair<int,int>, vector<pair<int,int>>, greater<>> pq;
    
    int n;
    cin>>n;
    int tmp;
    for(int i=0;i<n;i++) {
        cin>>tmp;
        if(tmp!=0) {
            pq.push({abs(tmp),tmp});
        }
        else {
            if(pq.empty()) {
                cout<<0<<"\n";
            }
            else {
                cout<<pq.top().second<<"\n";
                pq.pop();
            }
        }
    }
    return 0;
}
