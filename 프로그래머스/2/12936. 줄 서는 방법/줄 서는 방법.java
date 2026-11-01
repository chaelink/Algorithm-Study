import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            list.add(i);
        }
        
        long cnt = 1;
        for(int i=1; i<n; i++) {
            cnt*=i;
        }
        
        int nn = n;
        nn--;
        k--;
        for(int i=0; i<n-1; i++) {
            int d = (int)(k/cnt);
            answer[i] = list.remove(d);
            k%=cnt;
            cnt /= nn;
            nn--;
        }
        answer[n-1] = list.get(0);    
            
        return answer;
    }
}