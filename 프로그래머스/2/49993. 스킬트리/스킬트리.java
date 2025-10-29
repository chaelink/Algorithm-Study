import java.util.*;
//lcs 같은 느낌
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        //1. skill값과 순서를 해시맵에 저장
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<skill.length(); i++) {
            map.put(skill.charAt(i),i);
        }
        
        //2. 후보를 순회하는데 인덱스가 작아지면 안됨 
        for(int i=0; i<skill_trees.length; i++) {
            boolean check = true;
            int idx = 0;
            for(int j=0; j<skill_trees[i].length(); j++) {
                char c = skill_trees[i].charAt(j);
                if(map.containsKey(c)) {
                    if(idx != map.get(c)) {
                        check = false;
                        break;
                    } else {
                        idx++;
                    }
                    // if(idx==0) {
                    //     if(map.get(c)!=0) {
                    //         check = false;
                    //         idx++;
                    //         break;
                    //     }
                    // } else {
                    //     if(map.get(c)==idx+1) {
                    //         idx++;
                    //     } else {
                    //         check = false;
                    //         break;
                    //     }
                    // }
                }
            }
            if(check) answer++; 
        }
        
        return answer;
    }
}