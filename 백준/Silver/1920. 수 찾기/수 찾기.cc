#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int n;
    cin>>n;
    vector<int> arr(n);
    for(int i=0; i<n; i++) {
        cin>>arr[i];
    }
    sort(arr.begin(), arr.end());
    
    int m;
    cin>>m;
    vector<int> target(m);
    for(int i=0; i<m; i++) {
        cin>>target[i];
    }
    
    for(int i=0; i<m; i++) {
        int low=0; int high=n-1;
        bool found =false;
        while(low<=high) {
            int mid = (low+high)/2;
            if(target[i]==arr[mid]) {
                found=true;
                break;
            }
            else if(target[i]>arr[mid]) {
                low=mid+1;            
            }
            else if(target[i]<arr[mid]) {
                high=mid-1;
            }
        }
        if(found) {
            cout<<"1"<<"\n";
        }
        else {
            cout<<"0"<<"\n";
        }
    }
}