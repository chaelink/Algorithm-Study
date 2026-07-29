using namespace std;

long long solution(int price, int money, int count)
{
    long long answer = -1;
    long long total=0;
    for(int i=1; i<=count; i++) {
        total += price*i;
    }
    
    if(total - money <= 0) {
        return 0;
    } else {
        return total - money;
    }

}