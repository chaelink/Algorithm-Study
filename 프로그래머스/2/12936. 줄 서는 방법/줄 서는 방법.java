import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            list.add(i);
        }
        //1. 로직 잡고 풀기, 시간복잡도 분석, 단순화 고민
        // k가 최대 n!라는 정보를 통해 시간복잡도 최대 n!임을 알려줌
        
        for(int i=0; i<n; i++) {
            long count = 1;
            for(int j=n-1-i; j>=1; j--) {
                count *= j;
            }
            long d = (k-1)/count;
            answer[i] = list.get((int)d);
            list.remove((int)d);
            k -= count*d;
        }
        
        return answer;
    }
}