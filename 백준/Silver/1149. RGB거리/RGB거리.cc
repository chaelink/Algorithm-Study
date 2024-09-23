#include <iostream>
#include <algorithm>
using namespace std;
int arr[1001][3];
int cost[3];
int main() {
    int n;
    cin>>n;
    arr[0][0]=0;
    arr[0][1]=0;
    arr[0][2]=0;
    for(int j=1; j<=n; j++) {
        cin>>cost[0]>>cost[1]>>cost[2];
        arr[j][0]=min(arr[j-1][1],arr[j-1][2])+cost[0];
        arr[j][1]=min(arr[j-1][0],arr[j-1][2])+cost[1];
        arr[j][2]=min(arr[j-1][1],arr[j-1][0])+cost[2];
    }
    cout<< min(arr[n][0], min(arr[n][1], arr[n][2]));
    
    
   
}