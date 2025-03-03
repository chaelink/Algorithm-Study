#include <iostream>
#include <stack>
#include <vector>
using namespace std;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    stack<int> s;
    vector<char> listup;
    
    int n;
    cin>>n;
    int num=1;
    
    for(int i=0; i<n; i++) {
        int m;
        cin>>m;
        
        while(num<=m) {
            s.push(num);
            num++;
            listup.push_back('+');
        }
        if(s.top()==m) {
            listup.push_back('-');
            s.pop();
        } else {
            cout<<"NO"<<'\n';
            return 0;
        }
    }
    
    for(int i=0; i<listup.size(); i++) {
        cout<<listup[i]<<'\n';
    }
    return 0;
}