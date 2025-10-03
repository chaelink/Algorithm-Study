import java.util.*;

class Solution {
    public String solution(String s) {
        //큰 - 작
        //소 대
        String answer = "";
        
        //1. 대 소문자 분리
        List<Character> small = new ArrayList<>();
        List<Character> big = new ArrayList<>();
        //String small = "";
        //String big = "";
        
        for(char c : s.toCharArray()) {
            if(Character.isUpperCase(c)) {
                big.add(c);
            } else {
                small.add(c);
            }
        }
        
        //2. 내림차순 정렬
        Collections.sort(small, Collections.reverseOrder());
        Collections.sort(big, Collections.reverseOrder());
        
        for(char c : small) {
            answer += c;
        }
        for(char c : big) {
            answer +=c;
        }

        return answer;
    }
}