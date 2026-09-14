import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        //일단 가능한만큼 병사로 막고, 병사가 부족해지는 순간
        //과거 중 가장 큰 값 vs 현재 값 비교해서 더 적이 많은 곳에 무적권 사용

        int answer = 0;
        int m = enemy.length;
        if (k >= m) return m;
        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());

        for(int e : enemy) {
            pq.add(e);
            n -= e;
            answer++;
            if(n<0) {
                if(k==0) {
                    return answer-1;
                } else {
                    n += pq.poll();
                    k--;
                }
            }
        }

        return answer;
    }
}