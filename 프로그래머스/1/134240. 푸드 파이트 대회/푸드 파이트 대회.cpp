#include <string>
#include <vector>

using namespace std;

string solution(vector<int> food) {
    string answer = "0";
    
    for(int i=food.size()-1; i>0;i--) {
        
        if(food[i]==1) {
            continue;
        }
        int m = food[i]/2;
        for(int j=0; j<m; j++) {
            string s = to_string(i);
            answer = s + answer + s;
        }
    }
    
    return answer;
}