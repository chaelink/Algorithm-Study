import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        //fees 기본시간, 기본요금, 단위시간, 단위요금
        
        //입출차 기록
        Map<String, Integer> map = new HashMap<>();
        
        //최종 차량, 분 기록
        TreeMap<String,Integer> tmap = new TreeMap<>();
        
        for(String str : records) {
            String[] word = str.split(" ");
            String[] time = word[0].split(":");
            int minute = Integer.valueOf(time[0])*60 + Integer.valueOf(time[1]);
            if(word[2].equals("IN")) {
                map.put(word[1], minute);
            } else {
                int in_time = map.get(word[1]);
                map.remove(word[1]);
                int m = minute - in_time;
                tmap.put(word[1], tmap.getOrDefault(word[1],0)+m);               
            } 
        }
        
        if(map.size()>0) {
            for(String str : map.keySet()) {
                int out_m = 23*60 + 59;
                int m = out_m - map.get(str);
                tmap.put(str, tmap.getOrDefault(str,0)+m);
                // if(m > fees[0]) {
                //     fee += fees[1];
                //     m -= fees[0];
                //     int r = m/fees[2];
                //     if(m%fees[2]>0) r++;
                //     fee += r*fees[3];
                //     tmap.put(str, tmap.getOrDefault(str,0)+fee);
                // } else {
                //     fee += fees[1];
                //     tmap.put(str, tmap.getOrDefault(str,0)+fee);
                // }
            }
        }
        
        int[] answer = new int[tmap.size()];
        int idx=0;
        for(Map.Entry<String, Integer> entry : tmap.entrySet()) {
            int m = entry.getValue();
            int fee=0;
            if(m > fees[0]) {
                fee += fees[1];
                m -= fees[0];
                int r = m/fees[2];
                if(m%fees[2]>0) r++;
                fee += r*fees[3];
                answer[idx] = fee;
            } else {
                fee += fees[1];
                answer[idx] = fee;
            }
            idx++;
        }

        return answer;
    }
}