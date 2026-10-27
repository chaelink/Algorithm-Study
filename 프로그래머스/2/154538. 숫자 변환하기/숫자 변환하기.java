import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int[] visit = new int[1000001];
        visit[x] = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(x);
        
        while(!q.isEmpty()) {
            int d = q.poll();
            if(d==y) {
                return visit[d];
            }
            
            int cnt = visit[d];
            
            //1) x+n
            if(d+n<=1000000 && visit[d+n]==0) {
                visit[d+n] = cnt+1;
                q.add(d+n);
            }
            
            //2) x*2
            if(d*2<=1000000 && visit[d*2]==0) {
                visit[d*2] = cnt+1;
                q.add(d*2);
            }
            
            //3) x*3
            if(d*3<=1000000 && visit[d*3]==0) {
                visit[d*3] = cnt+1;
                q.add(d*3);
            }
        }
        
        return -1;
    }
}