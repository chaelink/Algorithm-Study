import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        int n = numbers.length;
        TreeSet<Integer> set = new TreeSet<>();
        
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        int[] answer = new int[set.size()];
        int idx = 0;
        for(Integer i : set) {
            answer[idx] = i;
            idx++;
        }
        
        return answer;
    }
}