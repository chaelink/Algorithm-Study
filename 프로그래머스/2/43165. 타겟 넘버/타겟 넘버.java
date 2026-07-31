import java.util.*;
class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        //주어진 숫자가 20개 이하이므로 완전탐색 가능
        
        dfs(0,0,numbers, target);
        
        return answer;
    }
    
    void dfs(int depth, int num, int[] numbers, int target) {
        if(depth == numbers.length) {
            if(num==target) answer++;
            return;
        }
        
        dfs(depth+1, num + numbers[depth], numbers, target);
        dfs(depth+1, num - numbers[depth], numbers, target);       
    }
}