import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        //1. 오늘 날짜 일 기준 정리
        String[] todayList = today.split("\\.");
        int today2 = Integer.parseInt(todayList[0])*28*12;
        today2 += Integer.parseInt(todayList[1])*28 + Integer.parseInt(todayList[2]);
        
        //1-1. 약관 정리
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<terms.length; i++) {
            String[] termsList = terms[i].split(" ");
            map.put(termsList[0], Integer.parseInt(termsList[1]));
        }
        
        //2. for문 순회
        for(int i=0; i<privacies.length; i++) {
            String[] pri = privacies[i].split(" ");
            String[] date = pri[0].split("\\.");
            int num = map.get(pri[1]);
            int day = Integer.parseInt(date[0])*28*12;
            day += Integer.parseInt(date[1])*28 + Integer.parseInt(date[2]);
            day += num*28;
            
            if(today2 >= day) {list.add(i+1);}
        }
        
        int[] answer = new int[list.size()];
        int idx = 0;
        for(Integer i : list) {
            answer[idx] = i;
            idx++;
        }
        
        return answer;
    }
}