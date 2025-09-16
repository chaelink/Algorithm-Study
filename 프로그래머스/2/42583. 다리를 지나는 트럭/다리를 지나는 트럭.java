import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<bridge_length; i++) {
            q.add(0);
        }
        int sum = 0;
        int idx = 0;
        while(!q.isEmpty()) {
            sum -= q.poll();
            if(idx<truck_weights.length) {
                if(sum + truck_weights[idx]<=weight) {
                q.add(truck_weights[idx]);
                sum += truck_weights[idx];
                idx++;
            } else {
                q.add(0);
            }
            }
            
            
            answer = answer+1;
        }
        return answer;
    }
}