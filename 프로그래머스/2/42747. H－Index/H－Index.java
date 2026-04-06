import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        Arrays.sort(citations);
        int max = citations[n-1];
        
        for(int i=max; i>=0; i--) {
            int up=0; int down = 0;
            for(int j=0; j<n; j++) {
                if(citations[j]>=i) up++;
                else down++;
            }
            if(up>=i) return i;
        }
        
        return answer;
    }
}