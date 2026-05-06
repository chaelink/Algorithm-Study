import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int n = targets.length;
        int[] answer = new int[n];
        Map<Character, Integer> map = new HashMap<>();
        for(String str : keymap) {
            for(int i=0; i<str.length(); i++) {
                if(map.containsKey(str.charAt(i))) {
                    if(map.get(str.charAt(i)) > i+1) {
                        map.put(str.charAt(i), i+1);
                    }
                } else {
                    map.put(str.charAt(i), i+1);
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            String s = targets[i];
            int count = 0;
            boolean check = true;
            for(int j=0; j<s.length(); j++) {
                if(!map.containsKey(s.charAt(j))) {
                    answer[i] = -1;
                    check = false;
                    break;
                } else {
                    count += map.get(s.charAt(j));
                }
            }
            if(check) {
                answer[i] = count;
            }
        }
        
        //키는 최대 100개
        
        return answer;
    }
}