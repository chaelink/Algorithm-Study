import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int m = n;
        int t = 10;
        
        while( m > 9) {
            answer += (m % t);
            m = (m/t);
        }
              answer += m;
        

//         // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
//         System.out.println("Hello Java");

        // int answer = 5;
        // System.out.println(answer++);
        // System.out.println(++answer);
        
        int n1 = 3;
        System.out.println(n1++ + ++n1);
        return answer;
    }
}

    