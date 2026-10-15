import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int n = words.length;
        int[] visit = new int[n];
        //단어, 횟수
        Map<String, Integer> map = new HashMap<>();
        
        //bfs
        Queue<String> q = new ArrayDeque<>();
        q.add(begin);
        map.put(begin,0);
        
        //큐(단어)
        while(!q.isEmpty()) {
            String str = q.poll();
            if(str.equals(target)) {
                return map.get(str);
            }
            
            for(int i=0; i<n; i++) {
                if(visit[i]==0) {
                    if(check(str, words[i])) {
                        q.add(words[i]);
                        visit[i] = 1;
                        map.put(words[i], map.get(str)+1);
                    }
                }
            }
        }   
        
        return 0;
    }
    
    boolean check(String a, String b) {
        int n = 0;
        for(int i=0; i<a.length(); i++) {
            if(a.charAt(i)!=b.charAt(i)) {
                n++;
            }
        }
        if(n!=1) {return false;}
        else return true;
    }
}