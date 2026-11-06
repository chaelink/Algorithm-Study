import java.util.*;
class Solution {
    public String solution(int a, int b) {
        //2월이 29일까지 있음
        // 일 수 -> 요일 구하기
        Map<Integer, String> map = new HashMap<>();
        map.put(0,"FRI"); map.put(1,"SAT"); map.put(2,"SUN");
        map.put(3,"MON"); map.put(4,"TUE"); map.put(5,"WED");
        map.put(6,"THU");
        
        int day = 0;
        for(int i=1; i<a; i++) {
            if(i==2) day += 29;
            else if(i==1 ||i==3||i==5||i==7||i==8||i==10||i==12) {
                day +=31;
            } else {
                day+=30;
            }
        }
        day+=b;
        day-=1;
        day %= 7;
        String answer = map.get(day);
        return answer;
    }
}