import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Arrays.sort(book_time, (a,b) -> {
            return a[0].compareTo(b[0]);
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        //첫번쨰 방은 갯수 하나 늘리고 pq에 종료+10분 삽입
        answer = 1;
        pq.add(min(book_time[0][1])+10);
        int room = 0;
        
        //for문
        //이번 입실 시간 기준 pq에서 뺼 수 있는거 체크, 재사용 or 갯수 늘리기 선택
        for(int i=1; i<book_time.length; i++) {
            String[] str = book_time[i];
            int time = min(str[0]);
            
            boolean go = true;
            while(go) {
                if(!pq.isEmpty() && pq.peek()<=time) {
                    pq.poll();
                    room++;
                } else {go = false;}
            }
            
            if(room>0) {
                room--;
            } else {
                answer++;
            }
            
            pq.add(min(str[1])+10);
        }
        
        return answer;
    }
    
    int min(String str) {
        String[] st = str.split(":");
        int sum = Integer.parseInt(st[0])*60 + Integer.parseInt(st[1]);
        return sum;
    }
}