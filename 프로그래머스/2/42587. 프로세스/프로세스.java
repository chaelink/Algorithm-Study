import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
       
        Queue<Entry> q = new ArrayDeque<>();
        int n = priorities.length;
        
        for(int i=0; i<n; i++) {
            q.add(new Entry(i,priorities[i]));
        }
        
        int count = 0;
        while(!q.isEmpty()) {
            Entry e = q.remove();
            boolean up = false;
            for(Entry en : q) {
                if(en.p > e.p) up = true;
            }
            if(up) {
                q.add(e);
            } else {
                if(e.idx == location) {
                    count++;
                    return count;
                } else {
                    count++;
                }
            }
        }
        return 0;

    }
    
}

class Entry {
        int idx;
        int p;
        
        public Entry(int idx, int p) {
            this.idx = idx;
            this.p = p;
        }
    }