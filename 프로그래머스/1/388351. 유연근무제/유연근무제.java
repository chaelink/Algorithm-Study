import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int n = schedules.length;
        int[] arr = new int[n];
        
        //1. 출근 인정 시각 분 단위로 치환해서 저장
        for(int i=0; i<n; i++) {
            schedules[i] = schedules[i]/100*60 + schedules[i]%100 + 10;
        }
        
        //for문 반복
        for(int i=0; i<7; i++) {
            if(startday==6 || startday==7) {
                startday = (startday%7)+1;
                continue;
            }
            startday = (startday%7)+1;
            for(int j=0; j<n; j++) {
                int num = timelogs[j][i];
                num = num/100*60 + num%100;
                
                if(num<= schedules[j]) {
                    arr[j]++;
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            if(arr[i]==5) answer++;
        }
        
        return answer;
    }
}