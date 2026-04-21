import java.util.*;

class Solution {
    public String solution(String s) {
        String[] str = s.split(" ");
        int n = str.length;
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.valueOf(str[i]);
        }
        Arrays.sort(arr);
        StringBuilder answer = new StringBuilder("");
        answer.append(arr[0]);
        answer.append(" ");
        answer.append(arr[n-1]);
        return answer.toString();
    }
}