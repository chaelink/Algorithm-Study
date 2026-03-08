import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
      
        //arr는 0부터 9
        //백만개 이하
        
        //다르면 결과 집합에 추가
        
        Queue<Integer> q = new ArrayDeque<>();
        int num = arr[0];
        q.add(num);
        for(int i=1; i<arr.length; i++) {
            if(num==arr[i]) {
                
            } else {
                num = arr[i];
                q.add(num);
            }
        }
        
        int[] answer = new int[q.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = q.remove();
        }
        
        return answer;
    }
}