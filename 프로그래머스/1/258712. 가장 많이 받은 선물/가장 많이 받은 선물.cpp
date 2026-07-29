#include <string>
#include <vector>
#include <algorithm>
#include <map>
int graph[51][51];
int jisu[51];
//선물지수 = 준 선물 - 받은 선물 즉, 선물을 받기보다 더 많이 준 사람
using namespace std;
//2차원 벡터에 주고받은 표 그리고 [a][b] > [b][a] a++  같거나 0이면 선물지수 체크
//최종 결과 set에 저장?
int solution(vector<string> friends, vector<string> gifts) {
    int n= friends.size();
    int m = gifts.size();
    int answer = 0;
    
    map<string, int> fr;
    
    for(int i=0; i<n; i++) {
        fr.insert({friends[i],i});
    }
    
    for(int i=0; i<m; i++) {
        int blank = gifts[i].find(" ");
        string a = gifts[i].substr(0,blank);
        string b = gifts[i].substr(blank+1);
        graph[fr[a]][fr[b]]++;
        jisu[fr[a]] +=1;
        jisu[fr[b]] -=1;
    }
    
    
    for(int i=0; i<n; i++) {
        int npresent =0;
        for(int j=0; j<n; j++) {
            if(i==j) {continue;}
            if(graph[i][j] > graph[j][i]) {
                npresent++;
            }
            if(graph[i][j] == graph[j][i]) {
                if(jisu[i]>jisu[j]) {
                    npresent++;
                }
            }
        }
        answer = max(answer,npresent);
    }
    

    
    
   
    return answer;
}