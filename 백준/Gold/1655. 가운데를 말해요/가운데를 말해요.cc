#include <iostream>
#include <queue>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

    priority_queue<int> max;
    priority_queue<int, vector<int>, greater<int>> min;
    
    int n;
    cin>>n;
    for(int i=1; i<=n; i++) {
        int num;
        cin>>num; 
        
        if(max.empty() || max.size()==min.size()) {
            max.push(num);
        } 
        else {
            min.push(num);
        }
        
        if(!max.empty() && !min.empty() && (max.top() > min.top())) {
            int tmp = max.top();
            int b = min.top();
            
            max.push(min.top());
            max.pop();
            min.pop();
            min.push(tmp);
        }
        cout<<max.top()<<"\n";
        
    }
    return 0;
}