import java.util.*;
class Solution {
    //소수
    Set<Integer> set = new HashSet<>();
    int[] visit;
    public int solution(String numbers) {
        
        StringBuilder sb = new StringBuilder("");
        String[] number = numbers.split("");
        visit = new int[numbers.length()];
        
        dfs(sb, number);
        
        return set.size();
    }
    
    void dfs(StringBuilder sb, String[] number) {
        if(sb.length()>0) {
            int num = Integer.parseInt(sb.toString());
            if(sosu(num)) {
                set.add(num);
            }
        }
        
        
        for(int i=0; i<number.length; i++) {
            if(visit[i]==0) {
                visit[i]=1;
                dfs(sb.append(number[i]), number);
                sb.deleteCharAt(sb.length()-1);
                visit[i]=0;
            }
        }
    }
    
    boolean sosu(int num) {
        if(num<=1) return false;
        if(num==2) return true;
        for(int i=2; i<num; i++) {
            if(num%i==0) return false;
        }
        return true;
    }
}