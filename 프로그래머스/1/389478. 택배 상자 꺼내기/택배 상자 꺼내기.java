import java.util.*;
class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        int h = n/w;
        if(n%w!=0) h++;
        int[][] arr = new int[h][w];
        int idx =1;
        int t = 0;
        int a=0;
        int b = 0;
        
        while(idx<=n) {
            if(t%2==0) {
                for(int i=0; i<w; i++) {
                    arr[t][i] = idx;
                    if(idx==num) {
                        a = t; b = i;
                    }
                    idx++;
                    if(idx>n) break;
                }
            } else {
                for(int i=w-1; i>=0; i--) {
                    arr[t][i] = idx;
                    if(idx==num) {
                        a=t; b=i;
                    }
                    idx++;
                    if(idx>n) break;
                }
            }
            t++;
        }
        
        //System.out.println(a + " "+b);
        
        for(int i=a; i<h; i++) {
            if(arr[i][b]!=0) answer++;
        }
         
        return answer;
    }
}