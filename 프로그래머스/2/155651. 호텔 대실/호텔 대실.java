import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 1;
        
        //입실 순서대로 정렬
        Arrays.sort(book_time, (a,b) -> {
            return a[0].compareTo(b[0]);
        });
        
        PriorityQueue<Integer> list = new PriorityQueue<>();
        list.add( change(book_time[0][1])+10 );
        
        for(int i=1; i<book_time.length; i++) {
            String now = book_time[i][0];
            int time = change(now);
            
            if(list.size()>0 && list.peek()<=time) {
                list.remove();
            } else {
                answer++;
            }
             
            list.add(change(book_time[i][1])+10);           
        }
           
        return answer;
    }
    
    int change(String str) {
        String[] s = str.split(":");
        return Integer.parseInt(s[0])*60 + Integer.parseInt(s[1]);
    }
}