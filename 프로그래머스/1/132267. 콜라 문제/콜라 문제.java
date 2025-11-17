class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n>=a) {
            int num = n / a;
            int dif = n % a;
            answer += num * b;
            n = num * b + dif;
        }
        return answer;
    }
}