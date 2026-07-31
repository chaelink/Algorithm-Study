import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        //반환 시간을 모두 더한 뒤 갯수로 나누기
        int answer = 0;
        
        //우선순위 대기 큐(번호, 요청시각, 소요시간)
        //소요시간이 짧은 것, 요청시각이 빠른 것, 번호가 작은 것 순
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[2]==b[2]) {
                if(a[1]==b[1]) {return a[0]-b[0];}
                else {return a[1]-b[1];}
            }
            return a[2] - b[2];       
        });
        
        //작업 요청 시점 순서대로 정렬
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        
        int n = jobs.length;
        int idx = 0; //몇번쨰 작업까지 큐에 들어갔는지
        int time = 0; //현재 시간
        
        while(idx < n) {
            //큐에 작업이 있으면 다음 작업 진행
            if(!pq.isEmpty()) {
                int[] now = pq.poll();
                time += now[2]; //시간 업데이트
                answer += (time - now[1]); //완료된 작업의 반환시간 더하기
                int here = idx; 
                //작업시간동안 도착한 큐 처리
                for(int i=here; i<n; i++) {
                    if(jobs[i][0]<=time) {
                        pq.add(new int[]{i, jobs[i][0], jobs[i][1]});
                        idx++;
                    } else {break;}
                }
            } else {
                // 큐가 비어 있는데 아직 작업이 남았다
                //다음 작업의 요청시간으로 현재 시간 당기기
                time = jobs[idx][0];
                pq.add(new int[]{idx, jobs[idx][0], jobs[idx][1]});
                idx++;
                int here = idx;
                for(int i=here; i<n; i++) {
                    if(jobs[i][0]==time) {
                        pq.add(new int[]{i, jobs[i][0], jobs[i][1]});
                        idx++;
                    } else {break;}
                }
            }
        }
        
        //모든 작업을 큐로 넣음, 큐가 아직 남음
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            time += now[2]; //시간 업데이트
            answer += (time - now[1]); //완료된 작업의 반환시간 더하기
        }
        
        return answer/n;
    }
}