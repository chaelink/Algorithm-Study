#include <string>
#include <vector>
#include <algorithm>
//실패율 = 도달but클리어실패 / 도달
//실패율이 높은 스테이지부터 출력
//pair 사용
using namespace std;


bool compare(const pair<int, float>& a, const pair<int,float>& b) {
    if(a.second != b.second) 
        return a.second > b.second;
    return a.first < b.first;
}
    
    
vector<int> solution(int N, vector<int> stages) {
    vector<pair<int,float>> arr;
    
    for(int i=1; i<= N; i++) {
        int nc=0; int arrive=0;
        for(int j=0; j<stages.size(); j++) {
            if(stages[j]==i) {
                nc++; arrive++;
            }
            else if(stages[j]>i) {
                arrive++;
            }
        }
        
        float rate = (arrive == 0) ? 0 : (float)nc / arrive;
        arr.push_back(make_pair(i,rate));
    }
    
    sort(arr.begin(), arr.end(), compare);
   
    vector<int> answer;
    for(int i=0; i<arr.size(); i++) {
        answer.push_back(arr[i].first);
    }
    
    return answer;
}