import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        int n = players.length;
        //String[] answer = new int[n];
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(players[i], i);
        }
        
        for(String str : callings) {
            int r = map.get(str);
            String name = players[r-1];
            players[r-1] = str;
            players[r] = name;
            map.put(str, r-1);
            map.put(name, r);
        }
        
        return players;
    }
}