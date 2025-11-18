import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder("");
        String[] str = s.split(" ");
        int[] arr = new int[str.length];
        
        for(int i=0; i<str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);
        int minn = arr[0];
        int maxx = arr[arr.length-1];
        
        answer.append(minn);
        answer.append(" ");
        answer.append(maxx);
        return answer.toString();
    }
}