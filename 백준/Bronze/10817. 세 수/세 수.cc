#include<iostream>
using namespace std;
int main() {
    int a,b,c;
    cin>>a>>b>>c;
    int second;
    if(a<b){
        if(a<c) {
            if(b<c)
                second=b;
            else
                second=c;
        }
        else
            second= a;           
    }
    else {
        if(b<c){
            if(a<c)
                second = a;
            else
                second = c;
        }
        else
            second = b;
    }
    cout<<second;
    
    return 0;
}