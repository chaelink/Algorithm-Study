import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int n = commands.length;
        int[] answer = new int[n];
        
        for(int idx=0; idx<n; idx++) {
            int i = commands[idx][0];
            int j = commands[idx][1];
            int k = commands[idx][2];
            List<Integer> list = new ArrayList<>();
            for(int q = i-1; q<j; q++) {
                list.add(array[q]);
            }
            Collections.sort(list);
            answer[idx] = list.get(k-1);
        }
        
        return answer;
    }
}