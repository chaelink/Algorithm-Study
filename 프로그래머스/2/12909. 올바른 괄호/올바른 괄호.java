import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int n = s.length();
        Deque<Integer> q = new ArrayDeque<>();
        
        for(int i=0; i<n; i++) {
            if(s.charAt(i) == '(') {
                q.add(1);
            } else {
                if(q.isEmpty()) {
                    answer = false;
                    break;
                } else {
                    q.pop();
                }
            }
        }
        
        if(!q.isEmpty()) answer = false;

        return answer;
    }
}