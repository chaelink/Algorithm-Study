#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    string s;
    cin>>s;
    int num[26]= {0};
    
    for(int i=0; i<s.size(); i++) {
        int a = s[i]-'A';
        num[a]++;
    }
    
    int check=0;
    for(int i=0; i<26; i++) {
        if(num[i]%2==1) {
            check++;
        }
        if(s.size()%2==1 && check==2) {
            cout<<"I'm Sorry Hansoo";
            return 0;
        }
        if(s.size()%2==0 && check==1) {
            cout<<"I'm Sorry Hansoo";
            return 0;
        }
    }
    
    string result;
    char mid=0;
    for(int i=0; i<26; i++) {
        if(num[i]%2==1) {
            mid = 'A'+i;
        }
        for(int j=0; j<num[i]/2; j++) {
            result += ('A'+i);
        }
    }
    string reverseresult = result; 
    reverse(reverseresult.begin(), reverseresult.end());
    if(mid!=0)
        result += mid;
    result += reverseresult;
    cout<<result;
    return 0;
    
}