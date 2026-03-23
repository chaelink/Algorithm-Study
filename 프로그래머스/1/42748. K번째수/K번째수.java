import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] answer = new int[n];
        int m = 0;
        
        for(int[] a : commands) {
            int[] temp = new int[a[1] - a[0]+1];
            int idx =0;
            for(int i=a[0]; i<=a[1]; i++) { 
                temp[idx] = array[i-1];
                idx++;
            }
            Arrays.sort(temp);
            answer[m] = temp[a[2] -1];
            m++;
        }
        
        return answer;
    }
}