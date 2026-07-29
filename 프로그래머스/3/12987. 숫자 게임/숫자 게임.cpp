#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<int> A, vector<int> B) {
    sort(B.begin(), B.end());
    sort(A.begin(), A.end());
    
    int answer = 0;
    int i=0; int j=0;
    while(i<A.size() && j<B.size()) {
        if(A[i]<B[j]) {
            i++;
            j++;
            //answer++;
        }
        else {
            j++;
        }
    }
   
    
    return i;
}