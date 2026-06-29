import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        List<Integer> list = new ArrayList<>();
        
        String[] tod = today.split("\\.");
        // for(int i=0; i<tod.length; i++) {
        //     System.out.println(i + " , " + tod[i]);
        // }
        String toda = tod[0] + tod[1] + tod[2];
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<terms.length; i++) {
            String[] now = terms[i].split(" ");
            map.put(now[0], Integer.parseInt(now[1]));
        }
        
        for(int i=0; i<privacies.length; i++) {
            String[] st = privacies[i].split(" ");
            String[] dates = st[0].split("\\.");
            int[] date = new int[3];
            date[0] = Integer.parseInt(dates[0]);
            date[1] = Integer.parseInt(dates[1]);
            date[2] = Integer.parseInt(dates[2]);
            
            int n = map.get(st[1]);
            
            date[1] += n;
            while(date[1]>12) {
                date[0] += 1;
                date[1] -= 12;
            }
            String d = date[0] + "";
            if(date[1]<10) {
                 d= d + "0";
            }
            d += date[1];
            if(date[2]<10) {
                d = d+"0";
            }
            d += date[2];
            //System.out.println(Integer.parseInt(toda));
            //System.out.println(Integer.parseInt(d));
            if(Integer.parseInt(toda) >= Integer.parseInt(d)) {
                list.add(i+1);
            }
            
        }
        Collections.sort(list);
        int[] answer = new int[list.size()];
        int idx = 0;
        for(Integer i : list) {
            answer[idx] = i;
            idx++;
        }
        
        //약관마다 유효기간 지정
        
        
        
        return answer;
    }
}