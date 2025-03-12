#include <iostream>
#include <stack>
using namespace std;
int main() {
    int k,n;
  
    cin>>k;
    stack<int> s;
    for(int i=0; i<k; i++) {
        cin>>n;
        if(n!=0) {
            s.push(n);
        } else {
            s.pop();
        }
    }
    int sum=0;
    int l = s.size();
    for(int i=0; i<l; i++) {
        sum += s.top();
        s.pop();
    }
    cout<<sum;
    return 0;  
   
}