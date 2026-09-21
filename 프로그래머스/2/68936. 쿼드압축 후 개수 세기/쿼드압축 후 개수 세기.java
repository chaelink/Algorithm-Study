import java.util.*;
class Solution {
    public int[] solution(int[][] arr) {
        int n = arr.length;
        int[] answer = new int[2];
        //방문 체크
        int[][] visit = new int[n][n];
        int idx = n;
        
        //큰 단위부터 보기(n부터 /2 1보다 클 떄까지)
        while(idx>1) {
            
            for(int i=0; i<n; i+=idx) {
                for(int ii=0; ii<n; ii+=idx) {
                    if(visit[i][ii]==0 && check(i,ii, idx, arr)) {
                        //answer 저장
                        if(arr[i][ii]==0){answer[0]++;}
                        else {answer[1]++;}
                        //방문 처리
                        for(int j=i; j<i+idx; j++) {
                            for(int k=ii; k<ii+idx; k++) {
                                visit[j][k]=1;
                            }
                        }
                    }
                }
            }
            idx = idx/2;
        }
        
        //방문안한 곳만 갯수 세서 answer에 저장
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(visit[i][j]==0) answer[arr[i][j]]++;
            }
        }
        
        return answer;
    }
    
    boolean check(int start, int sta, int n, int[][] arr) {
        int num = arr[start][sta];
        for(int i=start; i<start+n; i++) {
            for(int j=sta; j<sta+n; j++) {
                if(num != arr[i][j]) return false;
            }
        }
        return true;
    }
}