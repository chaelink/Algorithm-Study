import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int n = truck_weights.length;
        
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<bridge_length-1; i++) {
            q.add(0);
        }
        answer = 1;
        q.add(truck_weights[0]);
        
        //다리 위의 무게 합
        int sum = truck_weights[0];
        
        //몇번째 트럭까지 다리위에 올라갔는지(다음 올라갈 인덱스)
        int index = 1;
        
        while(!q.isEmpty()) {
            answer++;
            int rem = q.poll();
            sum -= rem;
            if(index<n) {
                if(sum + truck_weights[index] <=weight) {
                    q.add(truck_weights[index]);
                    sum += truck_weights[index];
                    index++;
                } else {
                    q.add(0);
                }
            }
        }
        
        
        return answer;
    }
}