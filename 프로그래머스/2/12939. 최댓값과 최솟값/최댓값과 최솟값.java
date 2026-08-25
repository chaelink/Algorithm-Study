import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split(" ");
        
        int n = str.length;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            list.add(Integer.parseInt(str[i]));
        }
        Collections.sort(list);
        answer = list.get(0) + " " + list.get(n-1);
        
        return answer;
    }
}