import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int mid = 0;
        long q1sum = 0;
        long q2sum = 0;
        int nn = queue1.length + queue2.length;
        
        //큐 2개 선언, 삽입, 합/2 구하기
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        
        for(int n : queue1) {
            q1.add(n);
            q1sum += n;
        }
        
        for(int n : queue2) {
            q2.add(n);
            q2sum += n;
        }
        
        //mid = (q1sum + q2sum)/2;
        
        while(answer < nn*4) {
            if(q1sum == q2sum) {
                return answer;
            }
            
            if(q1.isEmpty() || q2.isEmpty()) {return -1;}
            
            if(q1sum < q2sum) {
                int num = q2.poll();
                q1.add(num);
                q1sum += num;
                q2sum -= num;
                answer++;
            }
            
            if(q2sum < q1sum) {
                int num = q1.poll();
                q2.add(num);
                q1sum -= num;
                q2sum += num;
                answer++;
            }
        }
        
        return -1;
    }
}