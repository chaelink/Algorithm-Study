#include <iostream>
using namespace std;

int main() {
    int h,w,n,m;
    cin>>h>>w>>n>>m;
    int a = w / (m+1);
    if( w % (m+1) !=0)
        a++;
    int b = h / (n+1);
    if( h % (n+1) !=0)
        b++;
    cout<<a*b;
    return 0;
    
    
}