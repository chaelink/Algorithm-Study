#include <string>
#include <vector>
using namespace std;

int solution(string dartResult) {
    int answer = 0;
    vector<char> dartchar ;
    vector<int> score;
    for(int i=0; i<dartResult.length(); i++) {
        if(dartResult[i]=='1' && dartResult[i+1]=='0') {
            dartchar.push_back('A');
            i++; //1차 실패 부분
        }
        else {
            char ch = dartResult[i];
            dartchar.push_back(ch);
        }
    }
    
    for(int i=0; i<dartchar.size(); i++) {
        
        char ch = dartchar[i];
        int idx = score.size()-1;
        
        if(ch == 'A') {
            score.push_back(10);
        }
        
        if(ch >='0' && ch <='9') {
            int num = ch -'0';
            score.push_back(num);
        }
        if( ch == 'D') {
            score[idx] = score[idx]*score[idx];
        }
        
        if( ch == 'T') {
            score[idx] = score[idx]*score[idx]*score[idx];
        }
        if( ch== '*') {
            if(idx==0) {
                score[idx] = 2*score[idx];
            }
            else {
                score[idx] = 2*score[idx];
                score[idx-1] = 2*score[idx-1];
            }
        }
        
        if(ch=='#') {
            score[idx] = -1*score[idx];
        }
    }
    
    for(int i=0; i<score.size(); i++) {
        answer +=score[i];
    }
    
    
    return answer;
}