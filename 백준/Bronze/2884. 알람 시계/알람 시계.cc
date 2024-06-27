#include<iostream>
using namespace std;
int main(){
    int h,m;
    cin>>h>>m;
    if(m>=45){
        m -=45;
        cout<<h<<" "<<m;
    }
    else {
        int t =60+m-45;
        m = t;
        h-=1;
        if(h==-1)
            h = 23;
        cout<<h<<" "<<m;
    }
    
    return 0;
}