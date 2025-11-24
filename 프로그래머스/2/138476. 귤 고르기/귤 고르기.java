import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        //12233455
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i],0)+1);
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((a,b) -> {
            return map.get(b) - map.get(a);
        });
        
        for(Integer i : list) {
            if(k<=0) break;
            
            k = k - map.get(i);
            answer++;
        }
        
        return answer;
    }
}