import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int room = 0;
        int avail=0;
        
        //1. 입실 시간 순으로 정렬
        Arrays.sort(book_time, (a,b) -> a[0].compareTo(b[0]));
        
        //2. 퇴실 시간 저장하는 큐(pq)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int time = 0;
        
        for(String[] str : book_time) {
            //현재 시간 업데이트
            time = cal(str[0]);
            
            //큐에서 꺼낼 방 있으면 꺼내기 -> room 증가
            boolean go = true;
            while(!pq.isEmpty() && go) {
                int end = pq.peek();
                if(end<=time) {
                    pq.remove();
                    avail++;
                } else {go = false;}
            }
            
            //room 사용 or 증가, pq에 종료시간 추가
            if(avail>0) {
                avail--;
            } else {
                room++;
            }
            
            pq.add(cal(str[1])+10);
        }
        
        return room;
    }
    
    int cal(String str) {
        String[] s = str.split(":");
        return Integer.parseInt(s[0])*60 + Integer.parseInt(s[1]);
    }
}