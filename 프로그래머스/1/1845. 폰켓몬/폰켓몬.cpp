#include <vector>
#include <set>
#include <algorithm>
using namespace std;

int solution(vector<int> nums)
{
    int answer = 0;
    set<int> s;
    
    for(int i=0; i<nums.size(); i++) {
        s.insert(nums[i]);
    }
    int get = nums.size()/2;
    
    // if(s.size()>get) {
    //     return get;
    // } else {
    //     return s.size();
    // }
    return min(s.size(), nums.size()/2);
    
}