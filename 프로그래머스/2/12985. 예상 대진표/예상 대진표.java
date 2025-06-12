class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        // while(true) {
        //     if(a+1 == b) {
        //         if(a%2==0) return answer+2;
        //         else return answer+1;
        //     } else {
        //         if(a%2==0) a = a/2;
        //         else a= (a/2 +1);
        //         if(b%2==0) b = b/2;
        //         else b = (b/2+1);
        //         answer++;
        //     }
        // }
        while(true) {
            if(a==b) {
                return answer;
            }
            a= a/2 + a%2;
            b= b/2 + b%2;
            answer++;
        }
           
        //return answer;
    }
}