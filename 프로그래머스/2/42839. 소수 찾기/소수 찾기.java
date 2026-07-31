import java.util.*;
class Solution {
    int[] visit;
    int answer = 0;
    Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        
        //길이 최대가 7이므로 완전탐색 가능하다
        String[] number = numbers.split("");
        int n = numbers.length();
        visit = new int[n];
        StringBuilder sb = new StringBuilder("");
        
        dfs(sb, number);
        
        return set.size();
    }
    
    void dfs(StringBuilder sb, String[] number) {
        if(sb.length()>0) {
            if(check(sb.toString())) set.add(Integer.valueOf(sb.toString()));
        }
        
        for(int i=0; i<number.length; i++) {
            if(visit[i]==0) {
                visit[i]=1;
                sb.append(number[i]);
                dfs(sb, number);
                sb.deleteCharAt(sb.length()-1);
                visit[i]=0;
            }
        }
    }
    
    boolean check(String str) {
        int n = Integer.valueOf(str);
        if(n<=1) return false;
        
        for(int i=2; i<n; i++) {
            if(n%i==0) return false;
        }
        return true;
    }
    
    
}