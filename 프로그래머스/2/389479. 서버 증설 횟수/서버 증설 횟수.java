import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        //m명 당 1대
        //k시간동안 운영 후 반납
        //증설된 서버 당 운영 시간 관리 필요
        //시간대 별 배열 생성, 배열 값이 증설된 서버 수
        int[] server = new int[24];
        for(int i=0; i<players.length; i++) {
            //필요한 서버 수 구하기
            int n = 0;
            if(players[i]>0) {
                 n = players[i] / m;
            }
            
            //기존 증설되어있는 양 체크
            if(n>0) {
                int need = n - server[i];
                if(need>0) {
                    //증설
                    answer += need;
                    for(int j=i; j<i+k && j<24; j++) {
                        server[j] += need;
                    }
                    
                }
            }
        }
        
        return answer;
    }
}