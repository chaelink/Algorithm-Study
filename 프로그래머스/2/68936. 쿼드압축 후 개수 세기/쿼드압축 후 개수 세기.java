import java.util.*;
class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2]; //0,1개수
        int n = arr.length;
        int size = n;
        int[][] done = new int[n][n];
        
        while(size>1) {
            for(int i=0; i<n; i+=size) {
                for(int j=0; j<n; j+=size) {
                    if(done[i][j]==0 && merge(i,j,size,arr)) {
                        if(arr[i][j]==0) answer[0]++;
                        else answer[1]++;
                        for(int k=i; k<i+size; k++) {
                            for(int l=j; l<j+size; l++) {
                                done[k][l] = 1;
                            }
                        }
                    }
                }
            }
            size = size/2;
            //왼쪽 위 지점 골라서
            //합치기 가능한지 함수 돌리기
            //가능하면 0이나 1 ++ 하고 해당 면적 완료 처리
            
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(done[i][j]==0) {
                    if(arr[i][j]==0) answer[0]++;
                    else answer[1]++;
                }
            }
        }
        
        return answer;
    }
    
    boolean merge(int i, int j, int size, int[][] arr) {
        int num = arr[i][j];
        for(int k=i; k<i+size; k++) {
            for(int l=j; l<j+size; l++) {
                if(arr[k][l]!=num) return false;
            }
        }
        return true;
    }
}