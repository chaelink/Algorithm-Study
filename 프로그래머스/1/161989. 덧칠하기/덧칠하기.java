import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int paintedUntil = 0; // 마지막으로 칠해진 지점

        for (int s : section) {
            // 현재 구역(s)이 이미 칠해진 범위(paintedUntil) 밖에 있다면?
            if (s > paintedUntil) {
                answer++; // 새로 칠한다
                paintedUntil = s + m - 1; // 롤러를 대서 s부터 s+m-1까지 덮음
            }
        }
        
        return answer;
    }
}