import java.util.*;

class Solution {
    public int solution(String[] maps) {
        boolean check = false;
        int m1=0; int m2=0; int m3 =0;
        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};
        int answer = -1;
        int si=0;
        int sj=0;
        int n = maps.length;
        int m = maps[0].length();
        
        int[][] visited = new int[n][m];
        List<List<Character>> map = new LinkedList<>();
        
        for(int i=0; i<n; i++) {
            map.add(i, new LinkedList<>());  //1
            for(int j=0; j<m; j++) {
                map.get(i).add(maps[i].charAt(j));
                if(maps[i].charAt(j)=='S') {
                    si = i; 
                    sj= j;
                }
            }
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        visited[si][sj] = 1;
        q.add(new int[]{si, sj, 0});
        //1. S -> L
        while(!q.isEmpty()) {
            int[] now = q.poll();  //2
            
            int n1 = now[0]; int n2 = now[1]; int n3 = now[2];
            if(map.get(n1).get(n2)=='L') {
                check = true;
                m1 = n1;
                m2 = n2;
                m3 = n3;
                break;
            }
            
            for(int i=0; i<4; i++) {
                int ii = n1 + dx[i];
                int jj = n2 + dy[i];
                int time = n3+1;
                
                if(ii>=0 && ii<n && jj>=0 && jj<m && map.get(ii).get(jj)!='X' && visited[ii][jj]==0) {
                    visited[ii][jj] = 1;
                    q.add(new int[]{ii,jj,time});
                }
                
            }
        }
        if(!check) return answer;
        
        //앞에서 사용한 q 재사용 가능?
        q.clear();
        visited[m1][m2] = 2;
        q.add(new int[]{m1,m2,m3});
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            if(map.get(now[0]).get(now[1])=='E') {
                return now[2];
            }
            
            for(int i=0; i<4; i++) {
                int ii = now[0] + dx[i];
                int jj = now[1] + dy[i];
                int time = now[2] +1;
                if(ii>=0 && ii<n && jj>=0 && jj<m && map.get(ii).get(jj)!='X' && visited[ii][jj]!=2) {
                    visited[ii][jj] = 2;
                    q.add(new int[]{ii,jj,time});
                }
            }
            
        }
        
        
        //2. L -> E
        
        return answer;
    }
}