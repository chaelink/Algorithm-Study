import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] answer = new int[n];
        
        for(int i=0; i<n; i++) {
            int size = commands[i][1] - commands[i][0] +1;
            int[] arr = new int[size];
            
            int idx = 0;
            //2 부터 5
            for(int j=commands[i][0]; j<=commands[i][1]; j++) {
                arr[idx] = array[j-1];
                //System.out.println(arr[idx]);
                idx++;
            }
            
            Arrays.sort(arr);
            answer[i] = arr[commands[i][2]-1];
        }
        return answer;
    }
}