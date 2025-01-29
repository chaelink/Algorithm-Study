#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main() {
    string s;
    getline(cin, s); 

    string result; 
    stack<char> word; 
    bool inTag = false; 

    for (char c : s) {
        if (c == '<') {
          
            while (!word.empty()) {
                result += word.top();
                word.pop();
            }
            inTag = true;
            result += c; 
        } else if (c == '>') {           
            inTag = false;
            result += c; 
        } else if (inTag) {
            result += c;
        } else if (c == ' ') {           
            while (!word.empty()) {
                result += word.top();
                word.pop();
            }
            result += c; 
        } else {
            
            word.push(c);
        }
    }
    while (!word.empty()) {
        result += word.top();
        word.pop();
    }

    cout << result << endl;

    return 0;
}
