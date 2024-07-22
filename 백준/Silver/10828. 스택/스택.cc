#include<iostream>
#include <stack>
using namespace std;
int main() {
    stack<int> stack;
    int n;
    string command;
    int num;
    cin>>n;
    
    for (int i=0;i<n;i++) {
        cin>>command;
        
        if (command == "push") {
            cin>>num;
            stack.push(num);
        }
        if(command == "pop") {
            if(stack.empty())
                cout<<-1<<'\n';
            else {
                cout<<stack.top()<<'\n';
                stack.pop();
            }
        }
        if(command == "size") {
            cout<<stack.size()<<'\n';
        }
        if(command == "empty") {
            if(stack.empty())
                cout<<1<<'\n';
            else
                cout<<0<<'\n';
        }
        if(command == "top") {
            if(stack.empty())
                cout<<-1<<'\n';
            else
                cout<<stack.top()<<'\n';
        }
    }
    return 0;
}