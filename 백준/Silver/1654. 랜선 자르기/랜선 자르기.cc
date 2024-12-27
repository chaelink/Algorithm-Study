#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    
    int k,n;
    cin>>k>>n;
    
    vector<int>arr(k);
    for(int i=0; i<k; i++) {
        cin>>arr[i];
    }
    
    long long left = 1;
    long long right = *max_element(arr.begin(), arr.end());
    long long result = 0;
    
    while(left<=right) {
        long long mid = left + (right-left)/2;
        long long total =0;
        for(int i=0; i<k; i++) {
            total += arr[i]/mid;
            if(total>=n)
                break;
        }
        
        if(total >=n) {
            result = mid;
            left = mid+1;
        } else {
            right = mid-1;
        }
    }
    cout<<result;
    return 0;
}

