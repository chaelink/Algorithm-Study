import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder("");
        Map<Character, Integer> map = new HashMap<>();
        map.put('R',0);
        map.put('T',0);
        map.put('C',0);
        map.put('F',0);
        map.put('J',0);
        map.put('M',0);
        map.put('A',0);
        map.put('N',0);
        for(int i=0; i<survey.length; i++) {
            int num = choices[i];
            String str = survey[i];
            if(num==4) continue;
            if(num==1) map.put(str.charAt(0), map.get(str.charAt(0))+3);
            if(num==2) map.put(str.charAt(0), map.get(str.charAt(0))+2);
            if(num==3) map.put(str.charAt(0), map.get(str.charAt(0))+1);
            if(num==5) map.put(str.charAt(1), map.get(str.charAt(1))+1);
            if(num==6) map.put(str.charAt(1), map.get(str.charAt(1))+2);
            if(num==7) map.put(str.charAt(1), map.get(str.charAt(1))+3);
        }
        
        if(map.get('R') >= map.get('T')) {
            answer.append("R");
        } else {
            answer.append("T");
        }
        if(map.get('C') >= map.get('F')) {
            answer.append("C");
        } else {
            answer.append("F");
        }
        if(map.get('J') >= map.get('M')) {
            answer.append("J");
        } else {
            answer.append("M");
        }
        if(map.get('A') >= map.get('N')) {
            answer.append("A");
        } else {
            answer.append("N");
        }
        return answer.toString();
    }
}