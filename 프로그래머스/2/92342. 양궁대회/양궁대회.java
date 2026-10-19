import java.util.*;
class Solution {
    int[] ry = new int[11];
    int max = 0;
    boolean done = false;
    int[] answer = new int[11];
    public int[] solution(int n, int[] info) {
        dfs(0,n,info);
        
        if(!done) {
            int[] ans = {-1};
            return ans;
        }
        
        return answer;
    }
    
    //백트래킹으로 화살 날리기
    void dfs(int idx, int n, int[] info) {
        //0점 도달
        if(idx==10) {
            //남은 화살 0점에 쏘기
            ry[10] = Math.max(n,0);
            //점수 계산
            cal(info, ry);
            ry[10] = 0;
            return;
        }
        
        //탐색, 라이언이 점수 획득
        if(n > info[idx]) {
            ry[idx] = info[idx]+1;
            dfs(idx+1, n-(info[idx]+1), info);
            ry[idx] = 0;
        }
        
        //어피치가 점수 획득
        dfs(idx+1, n, info);
    }
    
    void cal(int[] info, int[] ry) {
        int a=0;
        int r=0;
        //어피치, 라이언 점수 계산
        for(int i=0; i<10; i++) {
            if(info[i]<ry[i]) {
                r += (10-i);
            } else {
                if(info[i]!=0) {
                    a += (10-i);
                }
            }
        }
        
        int num = r - a;
        
        //라이언>어피치면 갱신
        if(num > max) {
            done = true;
            //최종 화살 배열 저장
            answer = ry.clone();
            //차이 최대 업데이트
            max = num;
        } else if(num == max) {
            //현재 최고점수와 동일하면 조건 비교
            for(int i=10; i>=0; i--) {
                if(ry[i]>answer[i]) {
                    answer = ry.clone();
                    break;
                } else if(ry[i]<answer[i]) {break;}
            }
        }
    }
}