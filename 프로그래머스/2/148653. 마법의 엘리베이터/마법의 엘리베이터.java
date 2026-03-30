import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        //현재 위치 + 버튼 < 0 이면 움직이지 않음
        
        while(storey > 0) {
            int m = storey / 10;
            int s = storey % 10;
            if(s==5) {
                if(m % 10 >=5) {
                    answer += (10-s);
                    m++;
                } else {
                    answer += s;
                }
            } else if(s < 5) {
                answer += s;
            } else {
                answer += (10-s);
                m++;
            }
            storey = m;
        }
    
        return answer;
    }
}