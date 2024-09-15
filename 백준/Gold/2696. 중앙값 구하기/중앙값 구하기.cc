#include <iostream>
#include <queue>
using namespace std;

int main() {
    int n;
    cin>>n;
    for(int j=0; j<n; j++) {
        int m;
        priority_queue<int> max;
        priority_queue<int, vector<int>, greater<int>> min;
        cin>>m;
        cout<< m/2+1<<'\n';
        
        for(int i=0;i<m; i++) {
            int newn; 
            cin>>newn;
            
            if(max.size()==min.size()) {
                max.push(newn);
            } else if(max.size()>min.size()) {
                min.push(newn);
            }
            
            if(!max.empty() && !min.empty() && (max.top()>min.top())) {
                int a = max.top();
                int b = min.top();
                max.pop();
                min.pop();
                max.push(b);
                min.push(a);
            }
            if(i==0) {
                cout<<newn<<" ";}
            else if(i%2==0) {
                cout<<max.top()<<" ";
            }   
        }
        cout<<"\n";
    }
}