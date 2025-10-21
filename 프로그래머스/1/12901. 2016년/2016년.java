import java.util.*;

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0,"FRI");
        map.put(1,"SAT");
        map.put(2,"SUN");
        map.put(3,"MON");
        map.put(4,"TUE");
        map.put(5,"WED");
        map.put(6,"THU");
        
        if(a==1) {
            int day = b -1;
            day = day%7;
            return map.get(day);
        } else {
            int day = get(a-1);
            day += b;
            day = day % 7;
            return map.get(day);
        }
       
    }
    
    public int get(int month) {
        int answer = 0;
        for(int i=1; i<=month; i++) {
            if(i==1 || i==3 || i==5 || i==7 || i==8 || i==10 || i==12) {
                answer += 31;
            } else if(i==2) {
                answer += 29;
            } else {
                answer += 30;
            }
        }
        return answer-1;
    }
}