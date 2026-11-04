import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (a,b) -> {
            char ac = a.charAt(n);
            char bc = b.charAt(n);
            if(ac==bc) {
                return a.compareTo(b);
            } else {
                String as = ac+"";
                String bs = bc +"";
                return as.compareTo(bs);
            }
        });
        
        return strings;
    }
}