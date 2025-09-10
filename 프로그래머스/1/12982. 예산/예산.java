import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        //1. d의 값들 pq에 넣기
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<d.length; i++) {
            pq.add(d[i]);
        }
        
        //2. pq의 값들을 하나씩 예산 배정
        while(!pq.isEmpty() && budget >= pq.peek()) {
            answer++;
            budget -= pq.poll();
        }
        
        return answer;
    }
}