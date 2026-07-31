import java.util.*;
//35 ~
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(book_time, (a,b)-> {
            return a[0].compareTo(b[0]);
        });
        for(String[] str : book_time) {
            String[] in = str[0].split(":");
            int in_time = Integer.valueOf(in[0])*60 + Integer.valueOf(in[1]);
            String[] out = str[1].split(":");
            int out_time = Integer.valueOf(out[0])*60 + Integer.valueOf(out[1]);
            boolean done = false;
            for(Integer room : list) {
                if(room<=in_time) {
                    list.remove(room);
                    list.add(out_time+10);
                    done = true;
                    break;
                }
            }
            
            if(!done) {
                list.add(out_time+10);
                answer++;
            }
        }
        
        return answer;
    }
}