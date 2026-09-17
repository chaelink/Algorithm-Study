import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        //품목, 인덱스 저장
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<want.length; i++) {
            map.put(want[i], i);
        }
        
        //처음 10일
        for(int i=0; i<10; i++) {
            String name = discount[i];
            if(map.containsKey(name)) {
                int idx = map.get(name);
                number[idx]--;
            }
        }
        if(check(number)) answer++;
        
        for(int i=10; i<discount.length; i++) {
            //맨 앞 것 다시 추가
            String toAdd = discount[i-10];
            if(map.containsKey(toAdd)) {
                int idx = map.get(toAdd);
                number[idx]++;
            }
            
            //뒤 삭제
            String name = discount[i];
            if(map.containsKey(name)) {
                int idx = map.get(name);
                number[idx]--;
            }
            if(check(number)) answer++;
        }
        
        return answer;
    }
    
    boolean check(int[] number) {
        for(int i=0; i<number.length; i++) {
            if(number[i]!=0) {
                return false;
            }
        }
        return true;
    }
}