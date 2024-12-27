#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
    int n,m;
    cin>>n>>m;
    
    vector<int> arr(n);
    for(int i=0; i<n; i++) {
        cin>>arr[i];
    }
    int right = *max_element(arr.begin(), arr.end());
    int left = 0;
    int result =0;
    
    while(left<=right) {
        int mid = left + (right-left)/2;
        long long total = 0;
        for(int i=0; i<n; i++) {
            if(arr[i]-mid>0)
                total += arr[i]-mid;
        }
        
        if(total>=m) {
            result = mid;
            left = mid +1;
        } else {
            right = mid-1;
        }
    }
    cout<<result;
    return 0;
    
    
    
}