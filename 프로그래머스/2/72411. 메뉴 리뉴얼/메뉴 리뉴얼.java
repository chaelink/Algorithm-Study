import java.util.*;

class Solution {
    HashMap<String, Integer> map;
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
          
        for(int c : course) {
            map = new HashMap<>();
            for(String o : orders) {
                char[] ch = o.toCharArray();
                if(ch.length >= c) {
                    Arrays.sort(ch);
                    dfs(0, new String(ch), c, new StringBuilder());
                }
            }
            if(!map.isEmpty()) {
                int max = Collections.max(map.values());
            if(max>=2) {
                for(String s : map.keySet()) {
                    if(map.get(s)==max) {
                        answer.add(s);
                    }
                }
            }
            }
            
        }
        
        Collections.sort(answer);
        String[] ans = new String[answer.size()];
        int idx =0;
        for(String s : answer) {
            ans[idx] = s;
            idx++;
        }
        
        return ans;
        //return answer.toArray(new String[0]);
    }
    
    void dfs(int i, String s, int num, StringBuilder now) {
        if(now.length() == num) {
            map.put(now.toString(), map.getOrDefault(now.toString(),0)+1);
            return;
        }
        
        for(int ii=i; ii<s.length(); ii++) {
            now.append(s.charAt(ii));
            dfs(ii+1, s, num, now);
            now.deleteCharAt(now.length()-1);
        }
    }
}