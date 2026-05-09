import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        if(arr.length == 1) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        int n = arr.length;
        answer = new int[n-1];
        int m = Integer.MAX_VALUE;
        for(int i : arr) {
            if(i<m) m = i;
        }
        int idx = 0;
        for(int i : arr) {
            if(i != m) {
                answer[idx] = i;
                idx++;
            }
        }
        
        return answer;
    }
}