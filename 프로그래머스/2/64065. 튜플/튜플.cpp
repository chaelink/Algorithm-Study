#include <string>
#include <vector>
#include <algorithm>
// 튜플, 순서, 중복
//집합의 크기 활용
using namespace std;

vector<int> solution(string s) {
    vector<int> answer;
    vector<vector<int>> sets;
    vector<int> n;
    string num="";
    
    for(int i=2; i<s.length(); i++) {
        if(isdigit(s[i])) {
            num += s[i];
        } else if( s[i]=='}' || s[i]==',') {
            if(!num.empty()) {
                n.push_back(stoi(num));
                num="";
            }
            if(s[i]=='}') {
                sets.push_back(n);
                n.clear();
            }
        }
    }
    
    sort(sets.begin(), sets.end(), [](const vector<int>& a, const vector<int>& b) {
        return a.size() < b.size();  // 집합의 크기를 기준으로 오름차순 정렬
    });
    
    for( const auto& set : sets) {
        for(int num: set) {
            if(find(answer.begin(),answer.end(),num)==answer.end()) {
                answer.push_back(num);
            }
        }
    }
    
    return answer;
}