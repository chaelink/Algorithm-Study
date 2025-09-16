import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        //discount 최대 10만, want는 10
        //슬라이딩 윈도우
        //과일-개수 저장, 하나씩 삭제 => 어떤 자료구조 사용? 해시맵?
        
        int n = want.length;
        
        //1. want, number 해시맵에 저장, 이후 하나씩 카운트 줄이는 방식으로
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(want[i], number[i]);
            //System.out.println(want[i] + " " + number[i]);
        }
        
        //2. 슬라이딩윈도우로 가능한날 모두 체크
        int start = 0;
        int end = 10;
        
        //3. 첫케이스
        for(int i=start; i<end; i++) {
            String v = discount[i];
            //System.out.println(v);
            if(map.containsKey(v)) {
                int count = map.get(v);
                map.put(v,count-1);
            }
        }
        boolean can2 = true;
        for(Integer i : map.values()) {
            if(i>0) can2 = false;
            //System.out.println(i);
        }
        if(can2) answer++;
        
        int m = discount.length;
        //System.out.println("---");
        
        //slide
        for(int i2=end; i2<m; i2++) {
            String toAdd = discount[start];
            //System.out.println(toAdd);
            if(map.containsKey(toAdd)) {
                int count = map.get(toAdd);
                map.put(toAdd,count+1);
            }
            start++;
            String toMinus = discount[end];
            if(map.containsKey(toMinus)) {
                //System.out.println(toMinus);
                int count = map.get(toMinus);
                map.put(toMinus,count-1);
            }
            end++;
            
            boolean can = true;
            for(Integer i : map.values()) {
                if(i>0) can = false;
                //System.out.println(i);
            }
            if(can) answer++;
            //System.out.println("---");
        }
        
        return answer;
    }
}