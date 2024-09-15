#include<iostream>
#include<queue>
using namespace std;
int main() {
    queue<int> q;
    int n;
    cin>>n;
    for(int i=1;i<n+1;i++) {
        q.push(i);
    }
    int a = 1;
    while(q.size()!=1) {
        if(a%2==1) {
            q.pop();
            a++;
        }
        if(a%2==0) {
            q.push(q.front());
            q.pop();
            a++;
        }
    }
    cout<<q.front()<<'\n';
    return 0; 
}