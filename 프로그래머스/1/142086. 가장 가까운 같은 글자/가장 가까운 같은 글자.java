import java.util.*;

class Solution {
    public int[] solution(String s) {
        //알파벳과 인덱스를 저장?
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int[] answer = new int[n];
        
        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                answer[i] = -1;
            } else {
                int idx = map.get(c);
                answer[i] = i - idx;
            }
            map.put(c,i);
        }
        return answer;
    }
}