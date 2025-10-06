class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i=left; i<=right; i++) {
            if(cal(i)%2==0) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        return answer;
    }
    
    public int cal(int a) {
        int result=0;
        for(int i=1; i<=a; i++) {
            if(a%i == 0)result++;
        }
        return result;
    }
}