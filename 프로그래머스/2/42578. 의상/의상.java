import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        //1. 종류 별 갯수 정리
        for(String[] str : clothes) {
            map.put(str[1], map.getOrDefault(str[1],0)+1);
        }
        
        //2. 조합 - 1(모두 선택안한 경우)
        for(String name : map.keySet()) {
            answer *= (map.get(name)+1);
        }
        answer--;
          
        return answer;
    }
}