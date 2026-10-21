import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        //입차이면, 맵에 차량번호, 입차 시간 저장
        Map<String,String> map = new HashMap<>();
        Map<String, Integer> sumMap = new HashMap<>();
        for(String s : records) {
            String[] str = s.split(" ");
            if(str[2].equals("IN")) {
                map.put(str[1],str[0]);
            } else {
                String inTime = map.get(str[1]);
                map.remove(str[1]);
                sumMap.put(str[1],sumMap.getOrDefault(str[1],0)+cal(inTime,str[0]));
            }
        }
        
        //출차기록이 없는 차들
        for(String str : map.keySet()) {
            sumMap.put(str, sumMap.getOrDefault(str,0)+cal(map.get(str),"23:59"));
        }
        
        //요금 계산
        int n = sumMap.size();
        int[] answer = new int[n];
        List<String> list = new ArrayList<>();
        for(String s : sumMap.keySet()) {
            list.add(s);
        }
        Collections.sort(list);
        int idx = 0;
        for(String car : list) {
            int time = sumMap.get(car);
            if(time <= fees[0]) {
                answer[idx] = fees[1];
            } else {
                int p = time - fees[0];
                int m = (p/fees[2]);
                if(p % fees[2]>0) m++;
                answer[idx] = fees[1] + m*fees[3];
            }
            idx++;
        }
        
        return answer;
    }
    
    int cal(String in, String out) {
        String[] a = in.split(":");
        String[] b = out.split(":");
        return (Integer.parseInt(b[0])*60 + Integer.parseInt(b[1])) - (Integer.parseInt(a[0])*60 + Integer.parseInt(a[1]));
    }
}