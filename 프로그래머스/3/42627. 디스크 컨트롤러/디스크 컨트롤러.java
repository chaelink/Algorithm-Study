import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        int answer = 0;
        int n = jobs.length;
        int[] end = new int[n]; 
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) ->  jobs[a][1] - jobs[b][1]);
        
        int time = 0;
        int idx = 0;
        
        int count = 0;
        while(count<n) {
            while(idx<n && jobs[idx][0] <= time) {
                pq.add(idx);
                idx++;
            }
            
            if(!pq.isEmpty()) {
                int fin = pq.poll();
                time += jobs[fin][1];
                end[fin] = time - jobs[fin][0];
                count++;
                //System.out.println(end[fin]);
            } else {
                time = jobs[idx][0];
            }
        }
        
        for(int i : end) {
            System.out.println(i);
            answer += i;
        }
        
        //평균 반환시간 
        return answer/n;
    }
}