import java.util.*;
class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int x = routes.length;
        Map<String, Integer> map = new HashMap<>();
        
        //각 로봇의 포인트 순회 저장
        for(int[] route : routes) {
            int count=0;
            int[] p = points[route[0]-1];
            int r = p[0];
            int c = p[1];
            
            String str = count + "_" + r + "_" + c;
            //시작 위치 저장
            map.put(str, map.getOrDefault(str,0)+1);
            
            //2번째 포인트부터 경로 저장
            for(int i=1; i<route.length; i++) {
                p = points[route[i]-1];
                int tr = p[0];
                int tc = p[1];
                
                while(r != tr) {
                    count++;
                    if(r<tr) r++;
                    else r--;
                    str = count + "_" + r + "_" + c;
                    map.put(str, map.getOrDefault(str,0)+1);
                }
                while(c != tc) {
                    count++;
                    if(c<tc) c++;
                    else c--;
                    str = count + "_" + r + "_" + c;
                    map.put(str, map.getOrDefault(str,0)+1);
                }    
            }
        }
        
        for(String s : map.keySet()) {
            if(map.get(s)>=2) {
                answer++;
            }
        }
        
        return answer;
    }
}