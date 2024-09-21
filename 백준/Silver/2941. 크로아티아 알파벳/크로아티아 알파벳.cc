#include<iostream>
#include<string>
#include<vector>
using namespace std;
int main() {
    vector<string> croation = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    int idx;
    string str;
    cin>>str;
    for(int i=0;i<croation.size();i++) {
        while(1) {
            idx = str.find(croation[i]);
            if(idx==string::npos)
                break;
            str.replace(idx,croation[i].length(),"#");
        }
    }
    cout<<str.length();
}