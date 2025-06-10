import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        Arrays.sort(citations);
        int maxh = citations[n-1];
        for(int i=maxh; i>=1; i--) {
            int big=0; int small =0;
            for(int j=0; j<n; j++) {
                if(citations[j]>=i) {
                    big++;
                } else {
                    small++;
                }
            }
            if(big>=i && small<=i) {
                return i;
            }
            
        }
        return answer;
    }
}