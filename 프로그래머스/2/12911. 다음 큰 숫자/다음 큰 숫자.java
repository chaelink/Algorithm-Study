import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int count = cal(n);
        int m = n+1;
        
        while(true) {
            if(count == cal(m)) {
                answer = m;
                break;
            } else {
                m++;
            }
        }
        
        return answer;
    }
    
    //2진수 변환 함수
    public int cal(int n) {
        int answer = 0;
        while(n > 0) {
            answer += n%2;
            n = n/2;
        }
        return answer;
    }
}