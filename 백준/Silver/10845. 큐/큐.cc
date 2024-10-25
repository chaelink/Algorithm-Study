#include<iostream>
#include <queue>
using namespace std;
int main() {
    int n;
    cin>>n;
    string command;
    int num;
    queue<int> q;
    for (int i=0;i<n;i++) {
        cin>>command;
        if(command == "push") {
            cin>>num;
            q.push(num);
        }
        if(command == "pop") {
            if(q.empty())
                cout<<-1<<'\n';
            else {
                cout<<q.front()<<'\n';
                q.pop();
            }
        }
        if(command == "size") {
            cout<<q.size()<<'\n';
        }
        if(command == "empty") {
            if(q.empty())
                cout<<1<<'\n';
            else
                cout<<0<<'\n';
        }
        if(command == "front") {
            if(q.empty())
                cout<<-1<<'\n';
            else
                cout<<q.front()<<'\n';
        }
        if(command == "back") {
            if(q.empty())
                cout<<-1<<'\n';
            else
                cout<<q.back()<<'\n';
        }
    }
    return 0;
}