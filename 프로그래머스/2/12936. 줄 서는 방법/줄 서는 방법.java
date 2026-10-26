import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        //0. 전처리
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            list.add(i);
        }
        
        k--;
        long group = 1;
        for(int i=2; i<n; i++) {
            group *= i;
        }
        
        int idx = 0;
        for(int i=n-1; i>0; i--) {
            int d = (int)(k/group);
            answer[idx] = list.remove(d);
            k %= group;
            idx++;
            group /= i;
        }
        answer[idx] = list.get(0);
            
        return answer;  
    }
}