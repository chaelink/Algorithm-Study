//문제도 짧고 만만하게 보았으나 큰코다침
//한번에 안풀림 샤갈...

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i=0; i<n; i++) {
            q.add(prices[i]);
        }
        int idx = 0;
        while(!q.isEmpty()) {
            int now = q.remove();
            int time = 0;
            for(int a : q) {
                if(a >= now) time++;
                else {
                    time++; 
                    break;
                }
            }
            answer[idx] = time;
            idx++;
        }
        
        return answer;
    }
}