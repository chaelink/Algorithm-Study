#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;

int n,m;
int cnt=0;
string s;
vector <string> result;
map <string,bool> list;
int main() {
    cin>>n>>m;
    
    for(int i=0; i<n; i++) {
        cin>>s;
        list.insert(make_pair(s,true));
    }
    for(int i=0; i<m; i++) {
        cin>>s;
        if(list[s]) {
            result.push_back(s);
            cnt++;
        }
    }
    sort(result.begin(), result.end());
    cout<<cnt<<'\n';
    for(int i=0; i<cnt; i++) {
        cout<<result[i]<<'\n';
    }
    return 0;
}