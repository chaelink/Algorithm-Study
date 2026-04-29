import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder("");
        Map<Character, Integer> count = new HashMap<>();
        for(int i=0; i<X.length(); i++) {
            count.put(X.charAt(i), count.getOrDefault(X.charAt(i),0)+1);
        }
        List<Character> list = new ArrayList<>();
        
        for(int i=0; i<Y.length(); i++) {
            char c = Y.charAt(i);
            if(count.containsKey(c)) {
                list.add(c);
                int n = count.get(c) -1;
                if(n==0) {
                    count.remove(c);
                } else {
                    count.put(c,n);
                }
            }
        }
        
        if(list.isEmpty()) return "-1";
        
        if(Collections.max(list)=='0') return "0";
        
        Collections.sort(list, Collections.reverseOrder());
        
        for(Character c : list) {
            answer.append(c);
        }
        
        return answer.toString();
    }
}