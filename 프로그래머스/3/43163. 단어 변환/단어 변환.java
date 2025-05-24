import java.util.*;

class Solution {
    class Word {
        String word;
        int count;
        Word(String word, int count){
            this.word = word;
            this.count = count;
        }
    }
    int n;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        HashSet<String> visited = new HashSet<>();
        Queue<Word> q = new ArrayDeque<>();
        n = begin.length();
        
        visited.add(begin);
        q.add(new Word(begin,0));
        //int dist = 0;
        
        while(!q.isEmpty()) {
            Word w = q.remove();
            
            String s = w.word;
            if(s.equals(target)) {
                return w.count;
            }
            
            for(int i=0; i<words.length; i++) {
                if(wordCheck(s,words[i])==1 && !visited.contains(words[i])) {
                    q.add(new Word(words[i],w.count+1));
                    visited.add(words[i]);
                    System.out.println(words[i]);
                }
            }
           //dist++; 
        }
        
        return answer;
    }
    
    public int wordCheck(String a, String b) {
        int diff=0;
        for(int i=0; i<n; i++) {
            if(a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        return diff;
    }
    
}