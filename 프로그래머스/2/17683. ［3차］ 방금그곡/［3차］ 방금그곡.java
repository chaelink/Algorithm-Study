import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        List<String[]> ans = new ArrayList<>();
        m = m.replace("C#","c");
        m = m.replace("D#","d");
        m = m.replace("F#","f");
        m = m.replace("G#","g");
        m = m.replace("A#","a");
        
        //1. 각 음악 별로, 재생 시간에 맞게 음 전처리
        for(String str : musicinfos) {
            String[] song = str.split(",");
            String[] st = song[0].split(":");
            String[] et = song[1].split(":");
            int minute = (Integer.parseInt(et[0]) - Integer.parseInt(st[0]))*60;
            minute += Integer.parseInt(et[1]) - Integer.parseInt(st[1]);
            StringBuilder mu = new StringBuilder("");
            song[3] = song[3].replace("C#","c");
            song[3] = song[3].replace("D#","d");
            song[3] = song[3].replace("F#","f");
            song[3] = song[3].replace("G#","g");
            song[3] = song[3].replace("A#","a");
            
            for(int i=0; i<minute; i++) {
                char c = song[3].charAt(i%song[3].length());
                mu.append(c);
            }
            
            //2. m을 포함하고 있는지 확인 contains
            if(mu.toString().contains(m)) {
                String[] go = {song[2], mu.toString()};
                ans.add(go.clone());
            }
        }
        
        //3. 
        Collections.sort(ans, (a,b) -> {
            String s1 = a[1];
            String s2 = b[1];
            return s2.length() - s1.length();
        });
        
        if(ans.size()==0) {
            return answer;
        }
            
        return ans.get(0)[0];
    }
}