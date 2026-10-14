import java.util.*;
class Solution {
    int n;
    int answer = 0;
    public int solution(int[] numbers, int target) {
        n = numbers.length;
        
        dfs(0,0,target, numbers);
        
        return answer;
    }
    
    void dfs(int idx, int sum, int target, int[] numbers) {
        //탈출
        if(idx==n) {
            if(sum ==target) {answer++;}
            return;
        }
        
        //탐색
        dfs(idx+1, sum + numbers[idx], target, numbers);
        dfs(idx+1, sum - numbers[idx], target, numbers);
        
    }
}