#include<iostream>
#include<cmath>
using namespace std;
int main() {
    int a,b,n;
    int result=0;
    int arr[] = {100, 50, 20, 10, 5, 2, 1};
    cin>>n;
    cin>>a; cin>>b;
    for(int i=0;i<n-2;i++) {
        int tmp;
        if(a<=b) {
            cin>>tmp;
            a +=tmp;
        } else {
            cin>>tmp;
            b +=tmp;
        } 
    }
    int diff = abs(a-b);
    for (int i=0;i<sizeof(arr);i++) {
        result += diff/arr[i];
        diff %= arr[i];
        if(diff==0)
            break;
    } 
    
    cout<<result;
    return 0;
}