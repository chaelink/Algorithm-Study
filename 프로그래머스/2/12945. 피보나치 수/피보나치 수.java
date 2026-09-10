import java.util.*;
class Solution {
    int[] arr;
    public int solution(int n) {
        arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        
        for(int i=2; i<n; i++) {
            fibo(i);
        }
        
        return fibo(n);
    }
    
    int fibo(int number) {
        if(number == 0) return arr[0];
        if(number == 1) return arr[1];
        
        arr[number] = arr[number-1]%1234567 + arr[number-2]%1234567;
        return arr[number]%1234567;
    }
}