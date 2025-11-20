import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder("");
        //모든 단어의 첫문자가 대문자 
        String[] str = s.split(" ");
        int n = str.length;
        List<String> str2 = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            if(str[i].length()>=1) {
                System.out.println(str[i]);
                String a = str[i].substring(0,1).toUpperCase();
                String b = str[i].substring(1).toLowerCase();
                str2.add(a+b); 
                answer.append(a+b+" ");
            } else {
                answer.append(" ");
            }
        }
        if(s.charAt(s.length()-1) != ' ') {
            answer.deleteCharAt(answer.length()-1);
        }
      
        return answer.toString();
    }
}