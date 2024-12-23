#include <iostream>
using namespace std;
int main() {
    int n;
    cin>>n;
    
    bool paper[100][100] = {false};
    
    int a,b;
    for(int i=0; i<n; i++) {
        cin>>a>>b;
        for(int j=0; j<10;j++) {
            for(int k=0; k<10; k++) {
                paper[a+j][b+k]=true;
            }
        }
    }
    int result =0;
    for(int i=0; i<100; i++) {
        for(int j=0; j<100; j++) {
            if(paper[i][j])
            result++;
        }
    }
    cout<<result;
}