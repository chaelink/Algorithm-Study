#include <iostream>
#include <vector>
using namespace std;
int main() {
    string s;
    cin>>s;
    vector<int> arr(26,0);
    
    for(int i=0; i<s.size(); i++) {
        s[i] = toupper(s[i]);
        arr[s[i]-'A']++;
      
    }
    
    int count =0;
    int ind = -1;
    bool dup = false;
    for(int i=0; i<arr.size(); i++) {
        if(arr[i]>count) {
            count = arr[i];
            ind = i;
            dup = false;
        } else if(arr[i]==count) {
            dup = true;
        }
    }
    if(dup) 
        cout<<"?"<<'\n';
    else 
        cout<< char('A'+ind)<<'\n';
    
    return 0;
}