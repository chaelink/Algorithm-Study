import java.util.*;
class Solution {
    int answer = Integer.MAX_VALUE;
    int n;
    int count;
    int[] visit;
    int[] pick;
    public int solution(int[] picks, String[] minerals) {
        //곡괭이 배열로 저장
        count = minerals.length;
        for(int i=0; i<3; i++) {
            n+=picks[i];
        }
        pick = new int[n];
        int idx=0;
        for(int i=0; i<3; i++) {
            for(int j=0; j<picks[i]; j++) {
                pick[idx] = i;
                idx++;
            }
        }
        visit = new int[n];
        
        dfs(0,0,0, minerals,picks);
        
        return answer;
    }
    
    void dfs(int p, int sum, int piro, String[] minerals,int[] picks) {
        //백트래킹
        //곡괭이를 다 썼거나 광물이 끝나면 끝
        if(p==n || sum == count) {
            answer = Math.min(answer, piro);
            return;
        }
        
        //탐색
        for(int i=0; i<3; i++) {
            if(picks[i]!=0) {
                picks[i] -=1;
                int value = cal(sum, i, minerals);
                dfs(p+1, Math.min(sum+5, count), piro+value, minerals,picks);
                picks[i] +=1;
            }
        }
    }
    
    int cal(int sum, int p, String[] minerals) {
        int answer =0;
        if(p==0) {
            for(int j=sum; j<Math.min(sum+5,count); j++) {
                answer+=1;
                }
        }
        if(p==1) {
            for(int j=sum; j<Math.min(sum+5,count); j++) {
                if(minerals[j].equals("diamond")) {answer+=5;}
                else {answer+=1;}
            }
        }
        if(p==2) {
            for(int j=sum; j<Math.min(sum+5,count); j++) {
                if(minerals[j].equals("diamond")) {answer+=25;}
                else if(minerals[j].equals("iron")) {answer+=5;}
                else answer+=1;
            }
        }
        return answer;
    }
    
}