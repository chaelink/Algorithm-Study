#include<iostream>
using namespace std;
int main() {
    int arr[10000]={1,0, };
    int tmp;
    for(int i=0;i<10000;i++) {
        if(i<10) {
            arr[i+i]=1;
        }
        else if(i<100) {
            arr[i+(i%10)+(i/10)]=1;
        }
        else if(i<1000) {
            arr[i+(i%10)+(i/10%10)+(i/10/10)]=1;
        }
        else if(i<10000) {
            tmp = i+(i%10)+(i%100/10)+(i%1000/100)+(i/1000);
            if(tmp<10000)
                arr[tmp]=1;
        }
        
    }
    for(int i=1;i<10000;i++) {
        if(!arr[i])
            cout<<i<<'\n';
    }
    return 0;
}