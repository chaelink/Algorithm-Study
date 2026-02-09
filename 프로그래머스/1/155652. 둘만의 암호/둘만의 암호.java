import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder("");
        // char[] abc = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j','k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w','x','y','z'};
        
        char[] abc = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        
        //s를 for문 돌며 인덱스 플러스, 스킵에 존재하면 한 칸 더 추가
        for(char c : s.toCharArray()) {
            int count = 0;
            int idx = c - 'a';
            while(count < index) {
                idx = (idx+1)%26;
                if(skip.contains(abc[idx]+"")) {
                    
                } else {
                    count++;
                }
            }
            
            answer.append(abc[idx]);
        }
        
        return answer.toString();
    }
}