import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        int[] one = new int[2*n];
        int sumAll = 0;
        for(int i=0; i<n; i++) {
            one[i] = elements[i];
            one[i+n] = elements[i];
            sumAll += elements[i];
        }
        Set<Integer> set = new HashSet<>();
        
        for(int i=1; i<n; i++) {
            for(int j=0; j<n; j++) {
                int sum = 0;
                int start = j;
                for(int k=0; k<i; k++) {
                    sum += one[start];
                    start++;
                }
                set.add(sum);
            }
        }
        set.add(sumAll);
        
        int answer = set.size();
        return answer;
    }
}