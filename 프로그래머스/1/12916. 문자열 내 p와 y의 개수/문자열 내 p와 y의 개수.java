import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int pp=0;
        int yy=0;
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");
        
        for(int i=0; i<s.length(); i++) {
            char c = Character.toLowerCase(s.charAt(i));
            if(c=='p'||c=='P') {
                pp++;
            }
            if(c=='y'||c=='Y') {
                yy++;
            }
        }
        if(pp==yy) {
            answer = true;
        } else {
            answer = false;
        }

        return answer;
    }
}