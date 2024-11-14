#include<iostream>
#include<cctype>
using namespace std;

int main() {
    string whole;
    cin>>whole;
    
    string num;
    int sum=0;
    int minus = 0;
    
    for(int i=0; i<whole.size(); i++) {
        if(isdigit(whole[i])) {
            num += whole[i];
        } else {
       
            int number = stoi(num);
            
            if(minus==0) {
                sum += number;
            } else {
                sum -= number;
            }
            if(minus==0 && whole[i]=='-') {
                minus=1;
            }
            num="";
        } 
    }
    int number = stoi(num);
    if(minus==0) {
           sum += number;
    } else {
         sum -= number;
    }
    cout<<sum;
        
   
}