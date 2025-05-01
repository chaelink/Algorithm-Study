import java.util.*;
import java.io.*;

class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        int n = numbers.length;
        
        
        dfs(numbers, n, 0, 0, target);
        
        return answer;
    }
    
    public void dfs(int[] numbers, int n, int idx, int a, int target) {
        if(idx ==  n) {
            if(a == target) {
                answer++;
            }
            return;
        }
        int nidx = idx+1;
        dfs(numbers, n, nidx, a+numbers[idx], target);
        dfs(numbers, n, nidx, a-numbers[idx], target);
        
    }
}