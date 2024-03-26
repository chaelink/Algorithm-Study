#include <iostream>
#include <queue>
using namespace std;

int main() {
    int n;
    cin>>n;
    
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    priority_queue<int> pq;
    
    int tmp;
    for(int i=0;i<n;i++) {
        cin>>tmp;
        if(tmp!=0) {
            pq.push(tmp);
        }
        else {
            if(pq.empty()) {
                cout<<0<<"\n";
            }
            else {
                cout<<pq.top()<<"\n";
                pq.pop();
                    
            }
        }
    }
    return 0;
}
