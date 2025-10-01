import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        
        if(arr.length == 1) {
            int[] answer = new int[]{-1};
            return answer;
        } else {
            int min = Integer.MAX_VALUE;
            for(int i=0; i<arr.length; i++) {
                min = Math.min(min, arr[i]);
            }
            int[] answer = new int[arr.length-1];
            int idx = 0;
            
            for(int i=0; i<arr.length; i++) {
                if(arr[i]==min){
                    continue;
                } else {
                    answer[idx] = arr[i];
                    idx++;
                }
            }
            return answer;
        }
    }
}