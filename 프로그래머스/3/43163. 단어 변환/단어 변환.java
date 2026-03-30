import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        //방문 체크
        int n = words.length;
        int[] visited = new int[n];
        Queue<String> q = new ArrayDeque<>();
        q.add(begin);
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                String str = q.poll();
                //System.out.println(str);
                if(str.equals(target)) return answer;
                
                for(int k=0; k<n; k++) {
                    if(visited[k]==0 && check(str, words[k])) {
                        visited[k]=1;
                        q.add(words[k]);
                        
                    }
                }
            }
            answer++;
        }
        
        return 0;
    }
    
    boolean check(String a, String b) {
        int n = a.length();
        int t = 0;
        for(int i=0; i<n; i++) {
            if(a.charAt(i) != b.charAt(i)) {
                t++;
            }
            if(t==2) return false;
        }
        return true;
    }
}