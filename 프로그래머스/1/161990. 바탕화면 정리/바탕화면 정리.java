import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        List<Integer>[] list = new ArrayList[4];
        for(int i=0; i<4; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<wallpaper.length; i++) {
            int n = wallpaper[i].length();
            for(int j=0; j<n; j++) {
                if(wallpaper[i].charAt(j)=='#') {
                    list[0].add(i);
                    list[1].add(j);
                    list[2].add(i+1);
                    list[3].add(j+1);
                }
            }
        }
        
        answer[0] = Collections.min(list[0]);
answer[1] = Collections.min(list[1]);
answer[2] = Collections.max(list[2]);
answer[3] = Collections.max(list[3]);
        

        return answer;
    }
}