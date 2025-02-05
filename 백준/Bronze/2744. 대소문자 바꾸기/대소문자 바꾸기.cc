#include <iostream>
using namespace std;

int main() {
    string s,ns;
    cin>>s;
    
    for(char &c : s) {
        if(islower(c)) {
            ns.push_back(toupper(c));
        } else if(isupper(c)) {
            ns.push_back(tolower(c));
        }
    }
    cout<<ns;
    return 0;
}