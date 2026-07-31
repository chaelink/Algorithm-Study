import java.util.*;
//2:10 ~
class Solution {
    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();
        
        //알파벳, 인덱스로 해시맵 관리, 마지막 인덱스 값 관리
        Map<String, Integer> map = new HashMap<>();
        map.put("A",1); map.put("B",2);map.put("C",3);
        map.put("D",4); map.put("E",5);map.put("F",6);
        map.put("G",7);map.put("H",8);map.put("I",9);
        map.put("J",10);map.put("K",11);map.put("L",12);
        map.put("M",13);map.put("N",14);map.put("O",15);
        map.put("P",16);map.put("Q",17);map.put("R",18);
        map.put("S",19);map.put("T",20);map.put("U",21);
        map.put("V",22);map.put("W",23);
        map.put("X",24);map.put("Y",25);map.put("Z",26);
        int idx = 27;
        
        int c=0;
        
        while(c<msg.length()) {
            //현재 알파벳
            StringBuilder sb = new StringBuilder("");
            sb.append(msg.charAt(c));
            boolean t = false;
            //다음 알파벳부터 체크
            for(int i=c+1; i<msg.length(); i++) {
                sb = sb.append(msg.charAt(i));
               
                //바로 다음 알파벳이 없으면
                if(!map.containsKey(sb.toString())) {
                    //사전추가
                    map.put(sb.toString(),idx);
                    idx++;
                    c=i;
                    //출력
                    sb.deleteCharAt(sb.length()-1);
                    list.add(map.get(sb.toString()));
                    t=true;
                    break;
                }
                //있으면 for문으로 그 다음 알파벳도 sb에 추가
            }
            if(!t) {
               list.add(map.get(sb.toString())); 
                c= msg.length();
            }
            
        }
        
        
        
        int[] answer = new int[list.size()];
        int ii=0;
        for(Integer l : list) {
            answer[ii] = l;
            ii++;
        }
        
        return answer;
    }
}