import java.util.*;
class Solution {
    int[][] visit;
    public int[] solution(int[][] arr) {        
        int[] answer = new int[2];
        int n = arr.length;
        int len = n;
        visit = new int[n][n];
        
        while(n>1) {
            for(int i=0; i<len; i+=n) {
                for(int j=0; j<len; j+=n) {
                    if(arr[i][j]==1 && visit[i][j]==0) {
                        if(check(i,j,n,arr)) {
                            answer[1]++;
                        }
                    }
                    if(arr[i][j]==0 && visit[i][j]==0) {
                        if(check(i,j,n,arr)) {
                            answer[0]++;
                        }
                    }
                }   
            }
            n/=2;
        }
        
        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                if(visit[i][j]==0) {
                    answer[arr[i][j]]++;
                }
            }
        }
        
            
        //인덱스, 길이 -> 모두 일치하면 해당 면적 모두 방문 처리, 1이면 1하나 증가
        //쪼개서 반복  
        
        return answer;
    }
    
    boolean check(int a, int b, int n,int[][] arr) {
        int num = arr[a][b];
        for(int i=a; i<a+n; i++) {
            for(int j=b; j<b+n; j++) {
                if(arr[i][j]!=num) return false;
            }
        }
        for(int i=a; i<a+n; i++) {
            for(int j=b; j<b+n; j++) {
                visit[i][j]=1;
            }
        }
        return true;    
    }
}