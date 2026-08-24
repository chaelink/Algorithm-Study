import java.util.*;
class Solution {
    int n,m;
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        n = park.length;
        m = park[0].length;
        Arrays.sort(mats);
        int k = mats.length;
        
        for(int i=k-1; i>=0; i--) {
            int mat = mats[i];
            for(int j=0; j<n; j++) {
                for(int l=0; l<m; l++) {
                    if(park[j][l].equals("-1")) {
                        if(canPlace(park, j, l, mat)) {return mat;}
                    }
                }
            }
        }
        
        return answer;
    }
    
    boolean canPlace(String[][] park,int i,int j,int mat) {
        if(i+mat-1>=n || j+mat-1 >=m) {return false;}
        for(int ii=i; ii<i+mat; ii++) {
            for(int jj=j; jj<j+mat; jj++) {
                if(!park[ii][jj].equals("-1")) return false;
            }
        }
        return true;
    }
}