import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=2; i<=n; i++) {
            if(sosu(i)) {answer++;}
        }
        return answer;
    }
    
    boolean sosu(int a) {
    if (a < 2) return false;   // 1, 0 처리
    if (a == 2) return true;
    if (a % 2 == 0) return false; // 짝수 제거

    for (int i = 3; i <= Math.sqrt(a); i += 2) {
        if (a % i == 0) return false;
    }
    return true;
}

}