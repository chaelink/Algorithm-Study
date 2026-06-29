import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int n = schedules.length;
        
        for(int i=0; i<n; i++) {
            int num = schedules[i];
            int h = num /100;
            int m = num %100;
            int newo = h*60 + m + 10;
            schedules[i] = newo;
        }
        
        int[] check = new int[n];
        //상품을 받을 직원이 몇 명인지
        //오늘부터 일주일 동안
        
        for(int i=0; i<7; i++) {
            //System.out.println(startday);
            if(startday==6 || startday==7) {
                //System.out.println("p");
                
                startday %=7;startday +=1;
                continue;
            }
            //System.out.println("d");
            for(int j=0; j<n; j++) {
                int now = timelogs[j][i]/100*60 + timelogs[j][i]%100;
                if(now<=schedules[j]) {
                    check[j]++;
                }
            }
            startday +=1;
            startday %=7;
        }
        
        for(int i=0; i<n; i++) {
            if(check[i]==5) answer++;
        }
        
        return answer;
    }
}