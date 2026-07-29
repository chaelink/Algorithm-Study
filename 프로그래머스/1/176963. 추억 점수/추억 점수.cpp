#include <string>
#include <vector>
// pair 사용 -> 3중for문 문제 -> map으로 수정하기
using namespace std;

vector<int> solution(vector<string> name, vector<int> yearning, vector<vector<string>> photo) {
    vector<int> answer;
    vector<pair <string, int>> p;
    
    for(int i=0; i<name.size(); i++) {
        p.push_back(make_pair(name[i], yearning[i]));
    }
    
    for(int i=0; i<photo.size(); i++) {
        int score=0;
        for(int j=0; j<photo[i].size(); j++) {
            for(int k=0; k<p.size(); k++) {
                if(p[k].first == photo[i][j])
                    score += p[k].second;
            }
        }
        answer.push_back(score);
    }
    
    return answer;
}