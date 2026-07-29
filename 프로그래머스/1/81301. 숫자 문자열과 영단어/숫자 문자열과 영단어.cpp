#include <string>
#include <vector>


using namespace std;

int solution(string s) {
    int answer = 0;
    string str = "";
    vector<string> arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    for (int i = 0; i < s.size(); i++) {
        // 숫자인 경우
        if (isdigit(s[i])) {
            answer = answer * 10 + (s[i] - '0');  
        } 
        // 숫자가 아닌 경우, 문자열로 숫자를 찾기 위해 처리
        else {
            str += s[i];  

            // arr에서 문자열을 찾기
            for (int j = 0; j < arr.size(); j++) {
                if (str == arr[j]) {  // 해당 숫자 이름을 찾으면
                    answer = answer * 10 + j;  // 해당 숫자를 추가
                    str = "";  // 문자열 초기화
                    break;
                }
            }
        }
    }
    
    return answer;
}
