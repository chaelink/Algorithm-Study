import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int a : scoville) {
            q.add(a);
        }
        while(q.peek()<K) {
            if(q.size()<2) {
                return -1;
            }
            int n = q.poll() + (q.poll()*2);
            q.add(n);
            answer++;
            
        }
        
        
        
        //모든 음식의 스코빌을 k이상
        
        //가장 낮은 두개를 섞음
        //섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)

        
        return answer;
    }
}