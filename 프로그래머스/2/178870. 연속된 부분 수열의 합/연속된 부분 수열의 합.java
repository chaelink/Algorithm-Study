import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        //길이가 짧고, 인덱스가 작은
        int bestl = 0; 
        int bestr = sequence.length-1;
        int l = 0;
        int r = 0;
        int sum = sequence[0];
        
        while(l<=r && r<sequence.length) {
            //부힙
            if(sum == k) {
                //업데이트
                if((r-l) < (bestr - bestl)) {
                    bestr = r; bestl = l;
                } else if((r-1) == (bestr - bestl)) {
                    if(l < bestl) {bestr = r; bestl = l;}
                }
                
                //조정
                r++;
                if(r<sequence.length) sum += sequence[r];            
            }
            
            //조정
            if(sum < k) {
                r++;
                if(r<sequence.length) sum += sequence[r];  
            }
            
            if(sum >k) {
                sum -= sequence[l];
                l++;
            }
        }
        
        answer[0] = bestl;
        answer[1] = bestr;
        
        return answer;
    }
}