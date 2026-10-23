import java.util.*;
class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        Map<String,Integer> map = new HashMap<>();
        
        for(int[] r : routes) {
            int time = 0;
            int sx = points[r[0]-1][0]; int sy = points[r[0]-1][1];
            String str = sx+" "+sy+" "+time;
            //System.out.println(str);
            map.put(str, map.getOrDefault(str,0)+1);
            time++;
            
            for(int i=0; i<r.length-1; i++) {
                //출발 위치, 도착 위치
                sx = points[r[i]-1][0]; sy = points[r[i]-1][1];
                int tx = points[r[i+1]-1][0]; int ty = points[r[i+1]-1][1];
                
                if(sx<tx) {
                    for(int j=sx+1; j<=tx; j++) {
                        str = j+" "+sy+" "+time;
                        //System.out.println(str);
                        map.put(str, map.getOrDefault(str,0)+1);
                        time++;
                    }
                } else {
                    for(int j=sx-1; j>=tx; j--) {
                        str = j+" "+sy+" "+time;
                        //System.out.println(str);
                        map.put(str, map.getOrDefault(str,0)+1);
                        time++;
                    }
                }
                
                if(sy<ty) {
                    for(int j=sy+1; j<=ty; j++) {
                        str = tx+" "+j+" "+time;
                        //System.out.println(str);
                        map.put(str, map.getOrDefault(str,0)+1);
                        time++;
                    }
                } else {
                    for(int j=sy-1; j>=ty; j--) {
                        str = tx+" "+j+" "+time;
                        //System.out.println(str);
                        map.put(str, map.getOrDefault(str,0)+1);
                        time++;
                    }
                }
            }
        }
        
        for(String str : map.keySet()) {
            //System.out.println(str);
            if(map.get(str)>=2) answer++;
        }  
        return answer;
    }
}