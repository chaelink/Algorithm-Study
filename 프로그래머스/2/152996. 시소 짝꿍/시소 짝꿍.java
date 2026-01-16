import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Double, Long> map = new HashMap<>();
        
        // 정렬을 하면 작은 값에서 큰 값으로 비율(2/3, 1/2, 3/4)만 체크하면 되서 편합니다.
        Arrays.sort(weights);
        
        for (int w : weights) {
            double d = (double) w;
            // 현재 몸무게와 짝이 될 수 있는 이전의 몸무게들이 있었는지 확인
            if (map.containsKey(d)) answer += map.get(d); // 1:1
            if (map.containsKey(d * 2 / 3)) answer += map.get(d * 2 / 3); // 2:3
            if (map.containsKey(d * 1 / 2)) answer += map.get(d * 1 / 2); // 1:2
            if (map.containsKey(d * 3 / 4)) answer += map.get(d * 3 / 4); // 3:4
            
            map.put(d, map.getOrDefault(d, 0L) + 1);
        }
        
        return answer;
    }
}