import java.util.*;
class Solution {
    public String solution(String number, int k) {
        int n = number.length();
        int cnt = n - k;
        String answer = "";
        String[] num = number.split("");
        int idx = 0;
        
        for(int c=cnt; c>0; c--) {
            int maxNum = -9; int maxIdx = -1;
            for(int i=idx; i<=n-c; i++) {
                if(maxNum < Integer.parseInt(num[i])) {
                    maxNum = Integer.parseInt(num[i]); maxIdx = i;
                    if(maxNum==9) break;
                }
            }
            answer += maxNum;
            idx = maxIdx+1;
        }
        
        return answer;
    }
}