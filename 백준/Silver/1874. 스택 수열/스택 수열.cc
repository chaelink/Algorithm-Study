#include<iostream>
#include<stack>
#include<vector>
using namespace std;
int main() {
    vector<char> resultv;
    stack<int> s;
    int num =1;
    string result = "t";
    
    int n;
    cin>>n;
    
    for(int i=0;i<n;i++) {
        int x;
        cin>>x;
        while(num<=x) {
            s.push(num);
            num++;
            resultv.push_back('+');
        }
        
        if(s.top()==x) {
            s.pop();
            resultv.push_back('-');
        }
        else {
            cout<<"NO";
            result="f";
            break;
        } 
    }

    if(result=="t") {
        for(int i=0;i<resultv.size();i++)
            cout<<resultv[i]<<'\n';
    }
    return 0;
}
