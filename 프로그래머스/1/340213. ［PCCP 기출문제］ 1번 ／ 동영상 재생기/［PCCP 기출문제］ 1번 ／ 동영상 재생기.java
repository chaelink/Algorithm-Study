import java.util.*;
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        StringBuilder answer = new StringBuilder("");
        //prev 10초 전 or 0
        //next 10초 후 or 마지막
        //현재 재생 위치가 오프닝 구간이면 자동으로 오프닝 끝으로 이동
        int m = Integer.valueOf(pos.substring(0,2));
        int s = Integer.valueOf(pos.substring(3));
        
        int now = m*60 + s;
        
        int vm = Integer.valueOf(video_len.substring(0,2));
        int vs = Integer.valueOf(video_len.substring(3));
        int v = vm*60 + vs;
        
        int op_sm = Integer.valueOf(op_start.substring(0,2));
        int op_ss = Integer.valueOf(op_start.substring(3));
        int op_em = Integer.valueOf(op_end.substring(0,2));
        int op_es = Integer.valueOf(op_end.substring(3));
        
        int ops = op_sm * 60 + op_ss;
        int ope = op_em*60 + op_es;
        
        if(now>=ops && now <=ope) {
            now = ope;
        }
        
        for(String str : commands) {
            if(str.equals("next")) {
                now+=10;
                if(now>=v) now = v; 
            }
            if(str.equals("prev")) {
                now -= 10;
                if(now<=0) now = 0;
            }
            
            if(now>=ops && now <=ope) {
                now = ope;
            }
        }
        
        if(now/60 < 10) {
            answer.append("0");
        }
        answer.append(now/60);
        answer.append(":");
        if(now%60 < 10) {
            answer.append("0");
        }
        answer.append(now%60);
        
        return answer.toString();
    }
}