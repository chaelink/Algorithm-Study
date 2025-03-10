#include<iostream>
using namespace std;
int main() {
    int n;
    cin>>n;
    int check=0;
    
    if(n<100) {
        cout<<n;
        return 0;
    } else {
        for(int i=100; i<=n; i++) {
            int a = i/100;
            int b = (i/10)%10;
            int c = i%10;
            if( b-a == c-b)
                check++;
        }
        cout<<check+99;
        return 0;
    }
}