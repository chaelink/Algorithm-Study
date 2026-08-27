import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        // 1번 : 12345 
        //2번 : 
        //3번 : 
        int[] n1 = {1,2,3,4,5};
        int[] n2 = {2,1,2,3,2,4,2,5};
        int[] n3 = {3,3,1,1,2,2,4,4,5,5};
        
        for(int i=0; i<answers.length; i++) {
            int n = answers[i];
            if(n == n1[i%5]) answer[0]++;
            if(n == n2[i%8]) answer[1]++;
            if(n == n3[i%10]) answer[2]++;
        }
        int max = Math.max(Math.max(answer[0],answer[1]),answer[2]);
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<3; i++) {
            if(answer[i] == max) list.add(i+1);
            //System.out.println(answer[i]);
        }
        
        
        
        int size = list.size();
        int[] ans = new int[size];
        int idx=0;
        for(Integer number : list) {
            ans[idx] = number;
            idx++;
        }
        
        return ans;
    }
}