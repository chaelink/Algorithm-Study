import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        //귤 사이즈, 갯수 저장
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i],0)+1);
        }
        
        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());
        //갯수가 많은 순서대로 픽해서 k개 채우기
        for(Integer num : list) {
            k -= num;
            answer++;
            if(k<=0) break;
        }
 
        return answer;
    }
}