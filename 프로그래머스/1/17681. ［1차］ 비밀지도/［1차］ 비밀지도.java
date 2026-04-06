import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[][] a1 = new int[n][n];
        int[][] a2 = new int[n][n];
        
        for(int i=0; i<n; i++) {
            for(int j=n-1; j>=0; j--) {
                a1[i][j] = arr1[i]%2;
                arr1[i] /= 2;
            }
        }
        
        for(int i=0; i<n; i++) {
            for(int j=n-1; j>=0; j--) {
                a2[i][j] = arr2[i]%2;
                arr2[i] /= 2;
            }
        }
        
        for(int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder("");
            for(int j=0; j<n; j++) {
                if(a1[i][j]==1 || a2[i][j]==1) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}