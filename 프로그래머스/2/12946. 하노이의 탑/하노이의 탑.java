import java.util.*;
class Solution {
    List<int[]> list = new ArrayList<>();
    public int[][] solution(int n) {
        //재귀
        //1. n-1개를 보조로 이동
        //2. 가장 큰 걸 목적지로
        //n-1개를 목적지로
        
        hanoi(n,1,3,2);
        int size = list.size();
        int[][] answer = new int[size][2];
        int idx=0;
        for(int[] l : list) {
            answer[idx][0] = l[0];
            answer[idx][1] = l[1];
            idx++;
        } 
        
        return answer;
    }
    
    void hanoi(int n, int from, int to, int via) {
        if(n==0) return;
        
        hanoi(n-1, from, via, to);
        
        list.add(new int[]{from,to});
        
        hanoi(n-1,via,to,from);   
    }
}