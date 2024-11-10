#include<iostream>
#include<queue>
using namespace std;
int main() {
    queue<int> q;
    int n,k;
    cin>>n>>k;
    int arr[n];
    
    for(int i=0;i<n;i++) {
        q.push(i+1);
    }
  
    int a;
    int ind=0;
    while(!q.empty()) {
        for(int i=0;i<k-1;i++) {
            a = q.front();
            q.pop();
            q.push(a);
        }
        arr[ind] = q.front();
        q.pop();
        ind ++;
    }
    
    
    cout<<"<"<<arr[0];
    for(int i=1;i<n;i++) {
        cout<<", "<<arr[i];
    }
    cout<<">";
    return 0;
}