import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        k--;
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            list.add(i);
        }
        
        for(int i=0; i<n; i++) {
            long m = 1;
            for(int j=n-i-1; j>0; j--) {
                m *=j;
            }
            int idx = (int)(k/m);
            answer[i] = list.get(idx);
            k -= (m*idx);
            list.remove(idx);
        }
        
        return answer;
    }
}