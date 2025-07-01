import java.util.*;
//반환시간의 평균 return

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        
        int n = jobs.length;
        List<int[]> roundTime = new ArrayList<>();    
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        int time = 0; int idx = 0; int total = 0;
        int count = 0;
        
        while(count < n) {
            while(idx<n && jobs[idx][0] <= time) {
                pq.add(jobs[idx]);
                idx++;
            }
            if(!pq.isEmpty()) {
                int[] done = pq.remove();
                time += done[1];
                total += (time - done[0]);
                count++;
            } else {
                time = jobs[idx][0];
            }
        }

        return total/n;
    }
}