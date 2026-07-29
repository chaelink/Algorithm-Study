#include <string>
#include <vector>

using namespace std;
// A == 65
// a == 97
string solution(string s, int n) {
    string answer = "";
    char Upper[] = "";
    
    for(char c : s) {
        if( c>= 'A' && c<= 'Z') {
            answer += ((c - 'A' + n) % 26) + 'A';
        } else if ( c >= 'a' && c<= 'z') {
            answer += ((c - 'a' + n) % 26) + 'a';
        } else if ( c == ' ') {
            answer += ' ';
        }
        
    }
    
    return answer;
}