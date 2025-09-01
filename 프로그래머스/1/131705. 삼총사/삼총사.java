import java.util.*;

class Solution {
    int answer;
    int n;
    int sum=0;
    int count=0;
    int[] visited;
    
    public int solution(int[] number) {
        answer = 0;
        n = number.length;
        visited = new int[n];
        
        comb(0, number, sum, count);
        
        return answer;
    }
    
    void comb(int idx, int[] number, int sum, int count) {
        if(sum==0 && count ==3) {
            answer++;
        } else {
            for(int i=idx; i<number.length; i++) {
                if(visited[i]==0) {
                    visited[i]=1;
                    sum += number[i];
                    count += 1;
                    comb(i+1, number, sum, count);
                    visited[i]=0;
                    sum -= number[i];
                    count -= 1;
                }
            }
        }
    }
    
    
}