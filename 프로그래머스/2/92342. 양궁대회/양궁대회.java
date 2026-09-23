import java.util.*;
class Solution {
    int[] answer = new int[11];
    int diff=0; //가장 큰 점수 차
    int[] last = new int[11];
   
    public int[] solution(int n, int[] info) {
        
        dfs(0,0,n,info);
        if(diff==0) {
            int[] ans = {-1};
            return ans;
        }
        
        return last;
    }
    
    void dfs(int round, int cnt, int n, int[] info) {
        //2. 탈출 조건 - 화살이 남으면 0점에 배치 후 원복
        if(round>10) {
            if(cnt<n) answer[10] = (n-cnt);
            //3. diff 계산
            cal(info, answer);
            answer[10] = 0;
            return;
        }
        
        //1. 선택지 탐색
        if((n-cnt) > info[round]) {
            answer[round] = info[round]+1;
            dfs(round+1, cnt+info[round]+1, n, info);
            answer[round] = 0;
        }
        
        dfs(round+1, cnt, n, info);      
    }
    
    //승패 점수 계산 함수
    void cal(int[] info, int[] answer) {
        int api=0;
        int ryn=0;
        for(int i=0; i<11; i++) {
            if(info[i]==0 && answer[i]==0) {
                continue;
            }
            if(info[i]<answer[i]) {
                ryn+=(10-i);
            } else {
                api+=(10-i);
            }
        }
        if(ryn>api) {
            if((ryn-api)>diff) {
                diff = ryn - api;
                last = answer.clone();
            }
            else if((ryn-api)==diff) {
                for(int i=10; i>=0; i--) {
                    if(answer[i]>last[i]) {
                        last = answer.clone();
                    }
                    if(answer[i] < last[i]) {
                        break;
                    }
                }
            }
        }
    }
}