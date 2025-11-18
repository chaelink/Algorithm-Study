import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        int m = strings.length;
        String[] answer = new String[m];
        
        Arrays.sort(strings, 
                    (a,b) -> {
                        if(a.charAt(n) == b.charAt(n)) {
                            return a.compareTo(b);
                        }
                        return a.charAt(n) - b.charAt(n);
                    });
        
        return strings;
    }
}