import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int n = queue1.length;
        long q1Sum=0; Queue<Integer> q1 = new ArrayDeque<>();
        long q2Sum=0; Queue<Integer> q2 = new ArrayDeque<>();
        
        for(int i=0; i<n; i++) {
            q1Sum += queue1[i]; q1.add(queue1[i]);
            q2Sum += queue2[i]; q2.add(queue2[i]);
        }
        long same = (q1Sum + q2Sum)/2;
        
        for(int i=0; i<3*n; i++) {
            if(q1Sum == q2Sum) {
                return answer;
            }
            if(q1Sum > q2Sum) {
                int a = q1.remove();
                q1Sum -= a;
                q2.add(a);
                q2Sum += a;
            } else {
                int a = q2.remove();
                q2Sum -= a;
                q1.add(a);
                q1Sum += a;
            }
            answer++;
        }
        return -1;
    }
}