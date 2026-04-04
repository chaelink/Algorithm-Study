import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] list = new int[number];
        for(int i=0; i<number; i++) {
            list[i] = count(i+1);
            if(list[i]>limit) list[i] = power;
            answer += list[i];
        }
        //기사단원 최대 10만명
        
        
        
        //약수의 개수에 해당하는
        return answer;
    }
    
    int count(int a) {
        int c = 0;
        for(int i=1; i*i<=a; i++) {
            if(a%i==0) c+=2;
            if(i*i==a) c--;
        }
        return c;
    }
}