import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        Map<String, String> name = new HashMap<>();
        int n = record.length;
        
        for(String s : record) {
            String[] str = s.split(" ");
            if(str[0].equals("Enter") || str[0].equals("Change")) {
                name.put(str[1], str[2]);
            }
        }
        
        List<String> ans = new ArrayList<>();
        
        for(String s : record) {
            String[] str = s.split(" ");
            if(str[0].equals("Enter")) {
                ans.add(name.get(str[1]) + "님이 들어왔습니다.");
            }
            if(str[0].equals("Leave")) {
                ans.add(name.get(str[1]) + "님이 나갔습니다.");
            }
        }
        
        String[] answer = new String[ans.size()];
        int idx = 0;
        for(String s : ans) {
            answer[idx] = s;
            idx++;
        }
        return answer;
    }
}