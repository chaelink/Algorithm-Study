import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer =  new StringBuilder("");
        StringBuilder sen = new StringBuilder("");
        int length = t * m;
        int idx = 0;
        
        //n진수문자열리스트 생성
        while(sen.length()<=length) {
            sen.append(Integer.toString(idx,n).toUpperCase());
            idx++;
        }
        
        int place = p-1;
        for(int i=0; i<t; i++) {
            answer.append(sen.charAt(place));
            place += m;
        }
        
        return answer.toString();
    }  
}