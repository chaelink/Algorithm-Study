import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        Set<Integer> visit = new HashSet<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(x);
        
        while(!q.isEmpty()) {
            int nn = q.size();
            for(int i=0; i<nn; i++) {
                int a = q.remove();
            if(a == y) return answer;
            
            if(!visit.contains(a+n) && (a+n <= y)) {
                q.add(a+n);
                visit.add(a+n);
            }
            if(!visit.contains(a*2) &&  (a*2 <= y)) {
                q.add(a*2);
                visit.add(a*2);
            }
            if(!visit.contains(a*3) &&  (a*3 <= y)) {
                q.add(a*3);
                visit.add(a*3);
            }
            }
            
            answer++;
        }
        return -1;
    }
}