import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();

        set.add(words[0]);
        for(int i=1; i<words.length; i++) {
            int l = words[i-1].length();
            if(words[i].charAt(0) == words[i-1].charAt(l-1) && !set.contains(words[i])) {
                set.add(words[i]);
            } else {
                int a = (i%n) + 1;
                int b = (i) /n + 1;
                answer[0] = a;
                answer[1] = b;
                return answer;
            }
        }
        return answer;
       
    }
}