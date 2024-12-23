#include<iostream>
#include <unordered_map>
using namespace std;
unordered_map<string,int> m;

int main() {
    ios::sync_with_stdio(false); // 입출력 속도 최적화
    cin.tie(0);
    int n,p;
    cin>>n>>p;
    string s;
    for(int i=0; i<n; i++) {
        cin>>s;
        m[s]++;
    }
    int result =0;
    for(int i=0; i<p; i++) {
        cin>>s;
        if(m[s]>0) {
            result++;
        }
    }
    cout<<result;
    return 0;
}