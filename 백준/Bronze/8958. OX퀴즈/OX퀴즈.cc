#include<iostream>
#include<string>
using namespace std;
int main(){
    int n,num=0,sum=0;
    string s;
    cin>>n;
    for(int i=0;i<n;i++) {
        cin>>s;
        for(int i=0;i<s.length();i++){
            if(s[i]=='O') {
                num ++;
                sum+=num;
            }
            else
                num =0;           
        }
        cout<<sum<<"\n";
        sum =0;
        num=0;
    }
    return 0;
}