import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        int idx = 0;
        int sort = 0;
        String[] s = {"code", "date", "maximum", "remain"};
        for(int i=0; i<4; i++) {
            if(ext.equals(s[i])) {
                idx = i;
                break;
            }
        }
        for(int i=0; i<4; i++) {
            if(sort_by.equals(s[i])) {
                sort = i;
                break;
            }
        }
        
        
        List<int[]> list = new ArrayList<>();
        for(int[] d : data) {
            if(d[idx] < val_ext) {
                list.add(d);
            }
        }
        
        final int sort2 = sort;
        Collections.sort(list, (a,b) -> a[sort2] - b[sort2]);
        
        int n = list.size();
        int[][] answer = new int[n][4];
        
        int i = 0;
        for(int[] q : list) {
            answer[i] = q;
            i++;
        }
        
        return answer;
    }
}