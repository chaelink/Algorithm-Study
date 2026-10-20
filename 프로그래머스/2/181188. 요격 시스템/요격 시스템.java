import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (a,b) -> a[0] - b[0]);
        int n = targets.length;
        //b나라 미사일을 최소로 사용해서 모든 폭격 요격하기
        
        //a나라, 폭격 미사일 최대 50만개 
        int idx = 0;
        int now = 0;
        while(idx<n) {
            //현재 시간은 인덱스 끝 시간
            now = targets[idx][1];
            
            int num = 0;
            //다음 인덱스 시작시간이 < 현재면 추가
            for(int i=idx+1; i<n; i++) {
                if(targets[i][0]<now) {
                    num++;
                    now = Math.min(now, targets[i][1]);
                } else {break;}
            }
            
            //인덱스 갱신
            idx += (num+1);
            answer++;
        }
        
        return answer;
    }
}