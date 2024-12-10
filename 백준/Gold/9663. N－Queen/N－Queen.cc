#include<iostream>
using namespace std;
int col[15];
int n,total=0;

bool check(int level) {
    for(int i=0; i<level; i++) {
        if(col[i]==col[level] || abs(col[level]-col[i])==level-i )
            return false;
    }
    return true;
}

void back(int x) {
    if(x==n)
        total++;
    else {
        for(int i=0; i<n; i++) {
            col[x]=i;
            if(check(x))
                back(x+1);
        }
    }
}

int main() {
    cin>>n;
    back(0);
    cout<<total;
}