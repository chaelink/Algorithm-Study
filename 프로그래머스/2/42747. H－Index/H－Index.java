import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int n = citations.length;
        int h = citations[n-1];
        //System.out.println(h);
        
        for(int i=h; i>=0; i--) {
            int l = 0;
            int u = 0;
            for(int j=0; j<n; j++) {
                if(citations[j]>=i) {
                    u++;
                } else {
                    l++;
                }
            }
            //System.out.println(u);
            //System.out.println(l);
            if(u>=i && l<=i) return i;
        }
        
        return answer;
    }
}