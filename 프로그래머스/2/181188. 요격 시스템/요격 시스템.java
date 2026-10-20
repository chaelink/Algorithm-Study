import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));

        int answer = 0;
        int end = 0;

        for (int[] target : targets) {
            if (target[0] >= end) {
                answer++;
                end = target[1];
            }
        }

        return answer;
    }
}