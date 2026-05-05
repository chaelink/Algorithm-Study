import java.util.*;

class Solution {
    int answer = 0;
    int n = 0;
    public int solution(int[] numbers, int target) {
        n = numbers.length;
        
        dfs(0, 0, numbers, target);
        
        return answer;
    }
    
    void dfs(int idx, int num, int[] numbers, int target) {
        if(idx==n) {
            if(num == target) {
                answer++;
            }
            return;
        }
        
        dfs(idx+1, num + numbers[idx], numbers, target);
        dfs(idx+1, num - numbers[idx], numbers, target);
        
    }
}