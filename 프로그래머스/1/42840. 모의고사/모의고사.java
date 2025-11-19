import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] su1 = new int[]{1,2,3,4,5};
        int[] su2 = new int[]{2,1,2,3,2,4,2,5};
        int[] su3 = new int[]{3,3,1,1,2,2,4,4,5,5};
        
        int a=0,b=0,c=0;
        //1만 문제
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == su1[i%5]) a++;
            if(answers[i] == su2[i%8]) b++;
            if(answers[i] == su3[i%10]) c++;
        }
        
        int max = Math.max(Math.max(a,b),c);
        int n=0;
        
        int idx = 0;
        if(max == a) {
            n++;
        }
        if(max == b) {
            n++;
        }
        if(max == c) {
            n++;   
        }
        int[] answer = new int[n];
        if(max == a) {
            answer[idx] = 1;
            idx++;
        }
        if(max == b) {
            answer[idx] = 2;
            idx++;
        }
        if(max == c) {
            answer[idx] = 3;
            idx++;  
        }
        Arrays.sort(answer);
        return answer;
    }
}