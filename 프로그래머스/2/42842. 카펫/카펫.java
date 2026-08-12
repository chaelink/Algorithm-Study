import java.util.*;
class Solution {
    TreeSet<Integer> list = new TreeSet<>();
    int[] answer = new int[2];
    //List<Integer> ans = new ArrayList<>();
    int b;
    public int[] solution(int brown, int yellow) {
        b = brown;
        int row, col;
        int sum = brown + yellow;
        
        for(int i=1; i<sum/2; i++) {
            if(sum%i==0) {
                list.add(i);
                list.add(sum/i);
            }
        }
        
        dfs(0, answer); 
        
        return answer;
    }
    
    boolean dfs(int depth, int[] answer) {
        if(depth == 2) {
            if(answer[0] >= answer[1] && (2*answer[0] + 2*(answer[1]-2)) == b) {
                return true;
            } else {
                return false;
            }
        }
        
        for(Integer i : list) {
            answer[depth] = i;
            if(dfs(depth+1, answer)) return true;
            answer[depth] = 0;
        }
        return false;
    }
}