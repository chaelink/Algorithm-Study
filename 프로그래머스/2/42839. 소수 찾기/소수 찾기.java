import java.util.*;
class Solution {
    //최종 소수를 저장할 셋
    Set<Integer> set = new HashSet<>();
    int[] visit;
    int n;
    String[] arr;
    public int solution(String numbers) {
        
        n = numbers.length();
        visit = new int[n];
        arr = numbers.split("");
        
        StringBuilder sb = new StringBuilder("");
        dfs(sb);
        
        return set.size();
    }
    
    void dfs(StringBuilder sb) {
        if(sb.length()>0) {
            int num = Integer.parseInt(sb.toString());
            if(sosu(num)) set.add(num);
        }
        
        for(int i=0; i<n; i++) {
            if(visit[i]==0) {
                visit[i] = 1;
                sb.append(arr[i]);
                dfs(sb);
                sb.deleteCharAt(sb.length()-1);
                visit[i] = 0;
            }
        }
    }
    
    boolean sosu(int n) {
        if(n<=1) return false;
        for(int i=2; i*i<=n; i++) {
            if(n%i==0) return false;
        }
        return true;
    }
}